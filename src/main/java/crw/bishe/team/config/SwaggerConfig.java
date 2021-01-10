package crw.bishe.team.config;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    private static final String COMMON_ERROR_CLASS = "CommonErrorDTO";
    private static final String API_TITLe = "权限管理系统后端API";
    private static final String API_DESCRIPTION = "系统后台REST接口定义";
    private static final String API_LICENSE = "有crw开发编写";
    private static final String API_LICENSE_URL = "https://github.com/hellocrw/teamup-01";
    private static final String API_VERSION = "1.0.0-SNAPSHOT";

    private static final String TOKEN_HEADER = "token";
    private static final String TOKEN_TYPE = "Bearer";
    private static final String WORKING_ORGANIZATION = "Working-Organization";
    private static final String USER_TYPE = "User-Type";

    private static final String API_BASE_PACKAGE = "crw.bishe.team";

    private final TypeResolver typeResolver;

    @Autowired
    public SwaggerConfig(TypeResolver typeResolver) {
        this.typeResolver = typeResolver;
    }


    private Docket commonApi(String groupName,String basePackage,boolean requireToken){
        return this.buildApiCommonPart(new Docket(DocumentationType.SWAGGER_2)
                .groupName(groupName)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage)), requireToken);
    }

    private Docket buildApiCommonPart(ApiSelectorBuilder builder, boolean requireToken) {
        Docket docket = builder.paths(PathSelectors.any())
                .build()
                .consumes(
                        Stream.of(MediaType.APPLICATION_CBOR_VALUE)
                        .collect(Collectors.toSet())
                )
                .produces(
                        Stream.of(MediaType.APPLICATION_CBOR_VALUE)
                        .collect(Collectors.toSet())
                );
        if (requireToken){
            docket.globalOperationParameters(
                    Stream.of(
                            new ParameterBuilder()
                            .name(TOKEN_HEADER)
                            .modelRef(new ModelRef("string"))
                            .parameterType("header")
                            .required(true)
                            .description("JWT令牌")
                            .defaultValue(TOKEN_TYPE + "")
                            .build()
                    ).collect(Collectors.toList())
            );
        }
        docket.globalOperationParameters(
                Stream.of(
                        new ParameterBuilder()
                        .name(WORKING_ORGANIZATION)
                        .modelRef(new ModelRef("string"))
                        .parameterType("header")
                        .required(false)
                        .description("当前工作组织")
                        .build()
                ).collect(Collectors.toList())
        );
        docket.globalOperationParameters(
                Stream.of(
                        new ParameterBuilder()
                        .name(USER_TYPE)
                        .modelRef(new ModelRef("string"))
                        .parameterType("header")
                        .required(false)
                        .description("当前用户类型")
                        .build()
                ).collect(Collectors.toList())
        );
        return docket.pathMapping("/")
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, responseMessages())
                .globalResponseMessage(RequestMethod.PUT, responseMessages())
                .globalResponseMessage(RequestMethod.POST, responseMessages())
                .globalResponseMessage(RequestMethod.DELETE, responseMessages());
    }

    private List<ResponseMessage> responseMessages() {
        return Stream.of(
                new ResponseMessageBuilder()
                        .code(HttpStatus.BAD_REQUEST.value())
                        .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
                        .responseModel(new ModelRef(COMMON_ERROR_CLASS))
                        .build(),
                new ResponseMessageBuilder()
                        .code(HttpStatus.UNAUTHORIZED.value())
                        .message(HttpStatus.UNAUTHORIZED.getReasonPhrase())
                        .responseModel(new ModelRef(COMMON_ERROR_CLASS))
                        .build(),
                new ResponseMessageBuilder()
                        .code(HttpStatus.NOT_FOUND.value())
                        .message(HttpStatus.NOT_FOUND.getReasonPhrase())
                        .responseModel(new ModelRef(COMMON_ERROR_CLASS))
                        .build(),
                new ResponseMessageBuilder()
                        .code(HttpStatus.FORBIDDEN.value())
                        .message(HttpStatus.FORBIDDEN.getReasonPhrase())
                        .responseModel(new ModelRef(COMMON_ERROR_CLASS))
                        .build(),
                new ResponseMessageBuilder()
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                        .responseModel(new ModelRef(COMMON_ERROR_CLASS))
                        .build()).collect(Collectors.toList());
    }

    @Bean
    public Docket TestApi(){
        return this.commonApi("Test Management", API_BASE_PACKAGE + ".test", true);
    }

    @Bean
    public Docket DictionaryApi(){
        return this.commonApi("Dictionary Management", API_BASE_PACKAGE + ".dictionary", true);
    }


    @Bean
    public Docket createRestApi() {
//        return this.commonApi("All Management", API_BASE_PACKAGE+"", true);
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("All Management")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(API_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(setHeaderToken());
    }

    private List<Parameter> setHeaderToken() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<>();
        tokenPar.name("token")
                .description("token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        parameters.add(tokenPar.build());
        return parameters;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(API_TITLe)
                .description(API_DESCRIPTION)
                .license(API_LICENSE)
                .license(API_LICENSE_URL)
                .termsOfServiceUrl("none")
                .version(API_VERSION)
                .build();
    }
}
