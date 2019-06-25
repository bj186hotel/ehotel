package com.bj186.ssm.entity;

import com.bj186.ssm.pojo.User;
import com.bj186.ssm.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * @author 郑金城
 * @title: MyRealm
 * @projectName ssm
 * @description: TODO
 * @date 2019/6/2413:40
 */
public class MyRealm extends AuthorizingRealm {
    @Resource(name = "userService")
    private UserService userService;
    @Override
    //权限
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordByUserTypeToken usernamePasswordByUserTypeToken=(UsernamePasswordByUserTypeToken)authenticationToken;
        String userType = usernamePasswordByUserTypeToken.getUserType();
        SimpleAuthenticationInfo info = null;
        if(userType.equals("user")){//角色是用户类型
            User user = userService.login(Integer.parseInt(usernamePasswordByUserTypeToken.getUsername()));
            if (user == null)
                throw new UnknownAccountException("用户不存在！");
            ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUserid());    // 以用户名为加密盐值
            String realmName = getName();                                              // 当前realm对象的name，调用父类的getName()方法即可

            //认证的核心
            info = new SimpleAuthenticationInfo(user, user.getPassword(), credentialsSalt, realmName);

            // 在没有加盐的情况下，三个参数就可以进行初步的简单认证信息对象的包装
//        AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getSimpleName());
        }else if(userType .equals("member")){

        }
        return info;
    }
}
