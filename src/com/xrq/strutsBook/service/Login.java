package com.xrq.strutsBook.service;


import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.scut.dao.OperaDao;

public class Login {
	
	private String userName;
	private String  userPassword;
	private String uerType;
	private HttpSession se = ServletActionContext.getRequest().getSession();
	private String payLogin;
	

	public String userVerify()
	{
	
		if(se.getAttribute("name")!=null)  
		{
			return Action.SUCCESS;	
		}
		else return "noLogin";
	}
	
	public String login() 
	{
		String[] logInfo = new OperaDao().UserVerify(userName);
		if(logInfo[0].equals(userPassword))
		{
			uerType=logInfo[1];
			se.setMaxInactiveInterval(60);
			se.setAttribute("name",userName);
			se.setAttribute("type", uerType); 
			if(payLogin!=null)
			{
				return "toPay"; 
			}else
			return Action.SUCCESS;
		}
		else return Action.ERROR;
		
	}
	
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public HttpSession getSe() {
		return se;
	}
	public void setSe(HttpSession se) {
		this.se = se;
	}
	public String getUerType() {
		return uerType;
	}
	public void setUerType(String uerType) {
		this.uerType = uerType;
	}

	public String getPayLogin() {
		return payLogin;
	}

	public void setPayLogin(String payLogin) {
		this.payLogin = payLogin;
	}
	
	
}
