package crw.bishe.team.security;

import crw.bishe.team.entity.UserRoles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/1/31 0031
 * @Time 14:44
 */
public class SecurityUserDto extends UserRoles implements UserDetails {

    private static final long serialVersionUID = 991427483790164981L;

    public SecurityUserDto(UserRoles userRoles){
        if (userRoles != null){
            this.setUsername(userRoles.getUsername());
            this.setPassword(userRoles.getPassword());
            this.setAuth(userRoles.getAuth());
        }
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        String username = this.getUsername();
        if(username != null){
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(username);
            authorities.add(authority);
        }
        return authorities;
    }

    /**
     * 账户是否未过期，过期无法验证
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 指定用户是否解锁，锁定的用户无法进行身份验证
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 指示是否已过期的用户的凭据（密码），过期的凭据防止认证
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否可用，禁用的用户不能身份验证
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
