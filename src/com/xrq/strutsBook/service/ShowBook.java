package com.xrq.strutsBook.service;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.scut.bean.DataBean;
import com.scut.dao.OperaDao;

public class ShowBook extends ActionSupport{
	private String id;
	private DataBean dat1;

	public String detail()
	{
		System.out.println("displayId: "+id);
		dat1 = new OperaDao().getdata(id);
		if(dat1!=null)
			return Action.SUCCESS;
		else return Action.ERROR; 

		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DataBean getDat1() {
		return dat1;
	}

	public void setDat1(DataBean dat1) {
		this.dat1 = dat1;
	}
	


}
