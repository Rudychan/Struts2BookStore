package com.xrq.strutsBook.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.scut.bean.DataBean;
import com.scut.bean.OrderBean;
import com.scut.dao.OperaDao;

public class OrderSystem {
	private HttpSession se = ServletActionContext.getRequest().getSession();
	private String payment;
	private String orderId;
	private ArrayList<OrderBean>  orderDetail;
	private OrderBean orderBase;
	private DataBean userData;
	private OperaDao dbOpera = new OperaDao();
	private ArrayList<OrderBean> orderList;
	
	public String paySystem()
	{
		if(se.getAttribute("name")!=null)
			return "toPay";
		else	
			return "toLogin";
		
	}
	
	public String submitOrder()
	{
		if(orderId==null)
		{
			@SuppressWarnings("unchecked")
			ArrayList<DataBean> al = (ArrayList<DataBean>)se.getAttribute("cartList"); 
			
			userData = dbOpera.getUserData((String)se.getAttribute("name"));
			dbOpera.generateOrder(userData.getUserId(), payment);
			orderId = dbOpera.getOrderId();  //��ȡ������ 
			for(DataBean i:al)  //��ɶ���ϸ�ڣ� �����š���Ʒ���������������ݿ⣩
			{
				dbOpera.InsertorderDetail(orderId, i.getBookName(), i.getBookAmount());
			}
			
			orderDetail = dbOpera.getOrderDetail(orderId);
			orderBase = dbOpera.getOrder(orderId);
			
			return Action.SUCCESS;
		}else
		{
			userData = dbOpera.getUserData((String)se.getAttribute("name")); //ͨ���û�����ȡ�û���Ϣid����ַ��
			orderDetail = dbOpera.getOrderDetail(orderId);
			orderBase = dbOpera.getOrder(orderId);
			return Action.SUCCESS;
		}
			
	}
	
	public String showOrder()
	{
		
		DataBean db = dbOpera.getUserData((String)se.getAttribute("name"));
		String userId = db.getUserId();
		orderList  = dbOpera.getUserOrder(userId);
		return Action.SUCCESS;
	}
	
	
	
	
	
	
	

	public HttpSession getSe() {
		return se;
	}

	public void setSe(HttpSession se) {
		this.se = se;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public ArrayList<OrderBean> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(ArrayList<OrderBean> orderDetail) {
		this.orderDetail = orderDetail;
	}

	public OrderBean getOrderBase() {
		return orderBase;
	}

	public void setOrderBase(OrderBean orderBase) {
		this.orderBase = orderBase;
	}

	public DataBean getUserData() {
		return userData;
	}

	public void setUserData(DataBean userData) {
		this.userData = userData;
	}

	public ArrayList<OrderBean> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<OrderBean> orderList) {
		this.orderList = orderList;
	}
	

}
