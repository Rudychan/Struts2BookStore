package com.scut.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.scut.bean.DataBean;
import com.scut.dao.OperaDao;

/**
 * Servlet Filter implementation class DisplayIndex
 */
@WebFilter("/DisplayIndex")
public class DisplayIndex implements Filter {

    /**
     * Default constructor. 
     */
    public DisplayIndex() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("Get into the Filter");
		ArrayList<DataBean> newBooks = new ArrayList<DataBean>();
		newBooks = new OperaDao().displayIndex("new");  //–¬ È…œº‹£®NEW Books£©
		request.setAttribute("newBooks", newBooks);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
