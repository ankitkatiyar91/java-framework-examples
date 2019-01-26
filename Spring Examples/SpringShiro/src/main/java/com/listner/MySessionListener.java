package com.listner;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

public class MySessionListener implements SessionListener {

	@Override
	public void onExpiration(Session arg0) {
		System.out.println("MySessionListener.onExpiration()");

	}

	@Override
	public void onStart(Session arg0) {
		System.out.println("MySessionListener.onStart()");
	}

	@Override
	public void onStop(Session arg0) {
		System.out.println("MySessionListener.onStop()");

	}

}
