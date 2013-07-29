package de.edunet24.dev.login.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class LoginController implements  AsyncCallback<Boolean> {

	private final LoginServiceAsync loginService = GWT
			.create(LoginService.class);
	
	public void isLogged(){
		loginService.isLogged(this);
	}

	@Override
	public void onFailure(Throwable caught) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSuccess(Boolean result) {
		Window.Location.replace("/home");
		
	}

	
}
