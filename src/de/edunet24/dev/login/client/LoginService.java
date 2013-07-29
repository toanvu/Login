package de.edunet24.dev.login.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("loginservice")
public interface LoginService extends RemoteService {

	Boolean checkLogin(String username, String pwd, String company)
			throws IllegalArgumentException;
	
	boolean isLogged();
}
