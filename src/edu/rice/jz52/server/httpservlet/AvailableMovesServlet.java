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
public abstract class AvailableMovesServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3133499810173568197L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected abstract void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;

}
