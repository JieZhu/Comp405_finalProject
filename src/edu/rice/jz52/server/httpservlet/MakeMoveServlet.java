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
public abstract class MakeMoveServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6100774346756672621L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected abstract void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;
	
}
