package de.edunet24.dev.login.server;


import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.edunet24.dev.login.client.LoginService;
import de.edunet24.usermanager.dev.entityBeans.User;
import de.edunet24.usermanager.dev.entityInterfaces.ILogin;
import de.edunet24.usermanager.dev.entityInterfaces.IUserManager;

public class LoginServiceImpl extends RemoteServiceServlet implements
		LoginService {

	/* Static */
	private static final long serialVersionUID = 9122176216098480319L;

	/* Vars */

	/* Get & Set */

	/* Constructs */
	public LoginServiceImpl() {
		
	}

	/* Methods */
	@Override
	public Boolean checkLogin(String username, String pwd, String company)
			throws IllegalArgumentException {
		try{						
			if(this.getManager().login(username, pwd)){
				HttpSession session = getThreadLocalRequest()
						.getSession();
				session.setAttribute("user", this.getManager().getUser());
				//System.out.println("####################################### "+this.getManager().getUser().getEmail());
			}
			
			return this.getManager().login(username, pwd);
		}catch(IllegalArgumentException e1){
			e1.printStackTrace();
			return false;
		}
		
	}
	
	public ILogin getManager(){
		try{
			Properties props = new Properties();
			props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			
			Context context = new InitialContext(props);
	
			ILogin manager = (ILogin) context
					.lookup("ejb:/commonejb//LoginBean!de.edunet24.usermanager.dev.entityInterfaces.ILogin?stateful");
			

			return manager;
		}catch(NamingException e1){
			e1.printStackTrace();			
		}
		
		return null;
	}

	@Override
	public boolean isLogged() {
		HttpSession session = getThreadLocalRequest()
				.getSession();
		User user = (User) session.getAttribute("user");
		return user.getId()>0;
	}
}
