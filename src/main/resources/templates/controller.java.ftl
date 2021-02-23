package ${package.Controller};

import org.springframework.web.bind.annotation.*;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.http.ResponseEntity;
import crw.bishe.team.vo.Result;
import org.springframework.http.HttpStatus;

import javax.annotation.Resource;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@Api(tags = {"${table.comment!}"})
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??>:${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>public class ${table.controllerName} extends ${superControllerClass}{
<#else>public class ${table.controllerName} {
</#if>

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ${table.serviceName} ${(table.serviceName?substring(1))?uncap_first};


    @ApiOperation(value = "新增${table.comment!}")
    @PostMapping()
    public ResponseEntity<Result> add(@RequestBody ${entity} ${entity?uncap_first}){
        return new ResponseEntity<>(new Result<>(200, "success", ${(table.serviceName?substring(1))?uncap_first}.add(${entity?uncap_first})), HttpStatus.OK);
    }

    @ApiOperation(value = "删除${table.comment!}")
    @DeleteMapping("{id}")
    public ResponseEntity<Result> delete(@PathVariable("id") Long id){
        return new ResponseEntity<>(new Result<>(200, "success", ${(table.serviceName?substring(1))?uncap_first}.delete(id)), HttpStatus.OK);
    }

    @ApiOperation(value = "更新${table.comment!}")
    @PutMapping()
    public ResponseEntity<Result> update(@RequestBody ${entity} ${entity?uncap_first}){
        return new ResponseEntity<>(new Result<>(200, "success", ${(table.serviceName?substring(1))?uncap_first}.updateData(${entity?uncap_first})), HttpStatus.OK);
    }

    @ApiOperation(value = "查询${table.comment!}分页数据")
    @GetMapping()
    public ResponseEntity<Result<IPage<${entity}>>> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return new ResponseEntity<>(new Result<>(200, "success", ${(table.serviceName?substring(1))?uncap_first}.findListByPage(page, pageCount)), HttpStatus.OK);
    }

    @ApiOperation(value = "id查询${table.comment!}")
    @GetMapping("{id}")
    public ResponseEntity<Result<${entity}>> findById(@PathVariable Long id){
        return new ResponseEntity<>(new Result<>(200, "success", ${(table.serviceName?substring(1))?uncap_first}.findById(id)), HttpStatus.OK);
    }

}
</#if>