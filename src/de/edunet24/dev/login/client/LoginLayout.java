package de.edunet24.dev.login.client;



//import local.thingbook.login.view.gwt.client.LoginBtnHandler;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.widgets.layout.VLayout;

public class LoginLayout extends VLayout{

	private Button loginBtn;
	private TextBox email = null;
	private PasswordTextBox password = null;
	private TextBox refId = null;
	private Label info;
	private Login tbep;
	
	public LoginLayout(EntryPoint tbep){
		init();
	}
	
	public void init(){
		
		VerticalPanel verticalPanel = new VerticalPanel();
		this.addChild(verticalPanel);
		verticalPanel.setSize("266px", "206px");

		
		FlexTable flexTable = new FlexTable();
		verticalPanel.add(flexTable);
		
		Label lblNewLabel_1 = new Label("Username :");
		flexTable.setWidget(0, 0, lblNewLabel_1);
		
		email = new TextBox();
		email.setWidth("10em");
		flexTable.setWidget(0, 1, email);
		
		Label lblCompany = new Label("Reference ID:");
		flexTable.setWidget(2, 0, lblCompany);
		
		refId = new TextBox();
		refId.setWidth("10em");
		flexTable.setWidget(2, 1, refId);
		
		Label lblPassword = new Label("Password:");
		flexTable.setWidget(1, 0, lblPassword);
		
		password = new PasswordTextBox();
		password.setWidth("10em");
		password.addKeyDownHandler(new LoginBtnHandler(tbep, this));
		flexTable.setWidget(1, 1, password);
		
		CheckBox chckbxNewCheckBox = new CheckBox("Remember me");
		flexTable.setWidget(3, 1, chckbxNewCheckBox);
		
		loginBtn = new Button("Login");
		loginBtn.addClickHandler(new LoginBtnHandler(tbep, this));
		flexTable.setWidget(4, 0, loginBtn);
		
		flexTable.setWidget(5, 1, this.getInfo());
	}
	
	public Button getLoginBtn() {
		return loginBtn;
	}
	public void setLoginBtn(Button loginBtn) {
		this.loginBtn = loginBtn;
	}
	public TextBox getEmail() {
		return email;
	}
	public void setEmail(TextBox email) {
		this.email = email;
	}
	public PasswordTextBox getPassword() {
		return password;
	}
	public void setPassword(PasswordTextBox password) {
		this.password = password;
	}
	public TextBox getRefId() {
		return refId;
	}
	public void setRefId(TextBox refId) {
		this.refId = refId;
	}

	public Label getInfo() {
		return info;
	}

	public void setInfo(String info) {		
		this.info = new Label(info);
	}
	
	
	
	
}
