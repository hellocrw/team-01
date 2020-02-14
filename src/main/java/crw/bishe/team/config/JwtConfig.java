package crw.bishe.team.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/13 0013
 * @Time 20:21
 */
@ConfigurationProperties(prefix = "config.jwt")
@Component
@Data
@Log4j2
public class JwtConfig {
    /**
     * 过期时间，单位为秒
     */
    private long expire;

    /**
     * 存放token请求头对应的key的名字
     */
    private String headerKey;

    /**
     * 加密的secret
     */
    private String secret;

    /**
     * 根据身份ID标识，生成Token
     * @param identityId
     * @return
     */
    public String getToken(String identityId){
        Date nowDate = new Date();
        // 设置过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);
        return Jwts.builder()
                .setHeaderParam("typ","JWT")  // 设置头部信息
                .setSubject(identityId)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 获取Token中注册信息
     * @param token
     * @return
     */
    public Claims getTokenClaim(String token){
        try{
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            e.printStackTrace();
            log.info("获取Token失败");
            return null;
        }
    }

    /**
     * Token是否过期验证
     * @param expirationTime
     * @return
     */
    public boolean isTokenExpired (Date expirationTime){
        return expirationTime.before(new Date());
    }

}
