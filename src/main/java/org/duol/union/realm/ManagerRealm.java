package org.duol.union.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.duol.union.dao.ManageDao;
import org.duol.union.entity.Manage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Duolaimon
 * 17-11-12 下午6:28
 */
public class ManagerRealm extends AuthenticatingRealm{

    private ManageDao manageDao;

    @Autowired
    public ManagerRealm(ManageDao manageDao) {
        this.manageDao = manageDao;
    }

    /**
     *  登录
     *
     * @throws AuthenticationException  登录失败
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("--------------------ManagerRealm");
        System.out.println(token.getPrincipal().getClass());
        System.out.println(token.getCredentials().getClass());
        UsernamePasswordToken uToken = (UsernamePasswordToken)token;
        String username = uToken.getUsername();
        String password = String.valueOf(uToken.getPassword());
        Manage manage = manageDao.queryManage(username);
        if (manage == null || !manage.getManagePass().equals(password)){
            throw new UnknownAccountException("账号无效");
        }
        return new SimpleAuthenticationInfo(
                manage.getManageId(),manage.getManagePass(),getName()
        );
    }

    @Override
    protected void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }
}
