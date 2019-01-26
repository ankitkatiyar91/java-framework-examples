package com.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm {

	public MyRealm() {
		super();
		setCredentialsMatcher(new CredentialsMatcher() {
			
			@Override
			public boolean doCredentialsMatch(AuthenticationToken arg0,
					AuthenticationInfo arg1) {
				System.out
						.println("MyRealm.MyRealm().new CredentialsMatcher() {...}.doCredentialsMatch()");
				return true;
			}
		});
		
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		System.out.println("MyRealm.doGetAuthorizationInfo()");
		AuthorizationInfo info=new SimpleAuthorizationInfo();
		return info;
	}

	

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken arg0) throws AuthenticationException {
		System.out.println("MyRealm.doGetAuthenticationInfo()");
		UsernamePasswordToken token=(UsernamePasswordToken) arg0;
		
		AuthenticationInfo info=new SimpleAuthenticationInfo(1,token.getCredentials(), getName());
		return info;
	}

}
