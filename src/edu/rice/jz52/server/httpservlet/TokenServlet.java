/**
 * 
 */
package edu.rice.jz52.server.httpservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jz52@rice.edu
 *
 */
public abstract class TokenServlet extends HttpServlet {

	/**
	 * Serial ID generated automatically by eclipse 
	 */
	private static final long serialVersionUID = -5695796009771973102L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
