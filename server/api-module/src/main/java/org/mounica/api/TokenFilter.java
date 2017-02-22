package org.mounica.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

public class TokenFilter extends GenericFilterBean {
	 @Override
	    public void doFilter(final ServletRequest req,
	                         final ServletResponse res,
	                         final FilterChain chain) throws IOException, ServletException {
	        final HttpServletRequest request = (HttpServletRequest) req;
	        String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
	        List<String> allowedPaths = new ArrayList<>();
	        allowedPaths.add("/api/user/login");
	        allowedPaths.add("/api/user/create");
	        if(!allowedPaths.contains(path.trim())){
		        final String aHeader = request.getHeader("Authorization");	
	        }
	        chain.doFilter(req, res);
	    
	}


}
