package com.yaotengyuan.shiro.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.yaotengyuan.util.DecriptUtil;

public class MyShiroRealm extends AuthorizingRealm {

    //������Ϊû�е��ú�̨��ֱ��Ĭ��ֻ��һ���û�("luoguohui"��"123456")
    private static final String USER_NAME = "yaotengyuan";

    private static final String PASSWORD = "123456";

    /*
     * ��Ȩ
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        Set<String> roleNames = new HashSet<String>();
        Set<String> permissions = new HashSet<String>();
        roleNames.add("administrator");//��ӽ�ɫ
        permissions.add("newPage.jhtml"); //���Ȩ��
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        info.setStringPermissions(permissions);
        return info;
    }

    /*
     * ��¼��֤
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        if (token.getUsername().equals(USER_NAME)) {
            return new SimpleAuthenticationInfo(USER_NAME,
                    DecriptUtil.MD5(PASSWORD), getName());
        } else {
            throw new AuthenticationException();
        }
    }

}
