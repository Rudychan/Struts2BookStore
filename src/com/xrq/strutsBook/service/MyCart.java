package com.xrq.strutsBook.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.scut.bean.Cart;
import com.scut.bean.DataBean;
import com.scut.dao.OperaDao;

public class MyCart {
	private String id;
	private Cart c1;
	private HttpSession se2 = ServletActionContext.getRequest().getSession();
	private Boolean add;
	private Boolean minus;

	
	public String addToCart()
	{   Object cartObject = se2.getAttribute("cart");
		if(cartObject==null)
		{
			c1 = new Cart();		
			se2.setMaxInactiveInterval(30);
			se2.setAttribute("cart", c1);
		}else c1 = (Cart)cartObject;
		c1.addItem(id, 1); 
		System.out.println("加入购物车"+id); 
		return Action.SUCCESS;
			
	}
	
	public String showCart()
	{
		if(se2.getAttribute("cart")!=null)
		{
			c1=(Cart)se2.getAttribute("cart");
			String keySet= c1.displayItem();
			ArrayList<DataBean> al = new OperaDao().displayCart(keySet,c1);
			se2.setAttribute("cartList", al);
			return Action.SUCCESS;
		}else
			return Action.ERROR;
		
	}
	
	public String modifyCart()
	{
		if(add!=null)
		{
			c1=(Cart)se2.getAttribute("cart");
			c1.addItem(id, 1);
			return Action.SUCCESS;
		}
		
		if(minus!=null)
		{
			c1=(Cart)se2.getAttribute("cart");
			c1.minusItem(id);
			return Action.SUCCESS; 
		}
		return Action.ERROR;
	}
	
	public String delCartItem()
	{
		c1=(Cart)se2.getAttribute("cart");
		c1.delItem(id);
		return Action.SUCCESS;
	}

	public String delCart()
	{
		c1=(Cart)se2.getAttribute("cart");
		c1.delAll();
		return Action.SUCCESS;
	}
	
	
	public HttpSession getSe2() {
		return se2;
	}

	public void setSe2(HttpSession se2) {
		this.se2 = se2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Cart getC1() {
		return c1;
	}

	public void setC1(Cart c1) {
		this.c1 = c1;
	}

	public Boolean getAdd() {
		return add;
	}

	public void setAdd(Boolean add) {
		this.add = add;
	}

	public Boolean getMinus() {
		return minus;
	}

	public void setMinus(Boolean minus) {
		this.minus = minus;
	}



	
	

}
