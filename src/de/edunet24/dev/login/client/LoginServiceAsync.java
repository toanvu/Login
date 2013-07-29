package de.edunet24.dev.login.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {

	void checkLogin(String username, String pwd, String company,
			AsyncCallback<Boolean> callback) throws IllegalArgumentException;

	void isLogged(AsyncCallback<Boolean> callback);
}
