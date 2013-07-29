package de.edunet24.dev.login.client;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class LoginBtnHandler implements ClickHandler, AsyncCallback<Boolean>, KeyDownHandler{

	/* Static */

	/* Vars */
	private LoginLayout loginComposite;
	private Login tbep = null;
	private final LoginServiceAsync loginService = GWT
			.create(LoginService.class);

	/* Get & Set */

	/* Constructs */
	public LoginBtnHandler(Login tbep, LoginLayout loginComposite) {
		this.loginComposite = loginComposite;
		this.tbep = tbep;
	}

	/* Methods */


	@Override
	public void onSuccess(Boolean result) {
		Window.Location.replace("/home");
	}

	@Override
	public void onFailure(Throwable caught) {
		RootPanel.get().add(new Label("Exception: " + caught.toString(), true));
		this.tbep.getLoginLayout().setInfo("Fehler : "+caught.toString());
	}

	@Override
	public void onClick(ClickEvent event) {
		loginService.checkLogin(this.loginComposite.getEmail()
				.getValue(), this.loginComposite.getPassword()
				.getValue(),
				this.loginComposite.getRefId().getValue(), this);
	}
	
	@Override
	public void onKeyDown(KeyDownEvent event) {
		if(event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
			loginService.checkLogin(this.loginComposite.getEmail()
					.getValue(), this.loginComposite.getPassword()
					.getValue(),
					this.loginComposite.getRefId().getValue(), this);
		}
	}
}
