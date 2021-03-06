package com.scut.bean;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Cart {
	private String key="";
	private HashMap<String,String> hm = new HashMap<String,String>(); 
	
	public String getNum(String bookId) //查看某件商品在购物车中的数量 
	{
		return hm.get(bookId);
	}
	
	public void addItem(String bookId,int num)
	{
	
		if(bookId!=null)  
		{    //先查看目前本书数量，再添加新的
			String currentNum = hm.get(bookId);
			if(currentNum!=null)
				num +=Integer.parseInt(currentNum);
			hm.put(bookId, num+"");  //书籍ID和数量，数量默认为1
		}
	}
	
	public void delItem(String bookId)
	{
		if(bookId!=null)
		{
			hm.remove(bookId);
		}
	}
	
	public void delAll()
	{
			hm.clear();
	}
	
	public String displayItem()
	{
		key="";
		Set<String> keySet = hm.keySet();
		Iterator<String> iter = keySet.iterator();
		while(iter.hasNext())
		{
			key+="'"+iter.next()+"'";
			if(iter.hasNext())
			{
				key+=",";
			}
		}
		System.out.println("keySet: "+key);
		return key;
	}
	
	public void minusItem(String bookId)
	{
		int tmp=0;
		if(bookId!=null)  
		{    //先查看目前本书数量，再添加新的
			String currentNum = hm.get(bookId);
			if(currentNum!=null)
				tmp = Integer.parseInt(currentNum);
			if(tmp>1)
			{
				tmp -=1;
				hm.put(bookId, tmp+"");  //书籍ID和数量，数量默认为1
			}
			
			
		}
		
	}

}
