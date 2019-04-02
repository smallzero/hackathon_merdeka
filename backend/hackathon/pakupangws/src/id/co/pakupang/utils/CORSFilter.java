/*
 * File: CORSFilter.java
 * This class is created to handle all processing involved
 * in a PT. MMI Research.
 *
 * Copyright (c) 2015 Mitra Mandiri Informatika
 * Jl. Tebet Raya no. 11 B Jakarta Selatan
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary
 * information of Mitra Mandiri Informatika ("Confidential
 * Information").
 *
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the
 * license agreement you entered into with MMI.
 *
 * Date Author Version Changes
 * Apr 22, 2015	Agus Rochmad TR<mamat@mmi-pt.com> 		1.0 	Created
 */

/**
 * 
 */
package id.co.pakupang.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mamat
 *
 */
public class CORSFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
			ServletException {
		HttpServletResponse httpResp = (HttpServletResponse) resp;
		HttpServletRequest httpReq = (HttpServletRequest) req;

		httpResp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, OPTIONS");
		httpResp.setHeader("Access-Control-Allow-Origin", "*");
		if (httpReq.getMethod().equalsIgnoreCase("OPTIONS")) {
			httpResp.setHeader("Access-Control-Allow-Headers",
					httpReq.getHeader("Access-Control-Request-Headers"));
		}
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
