/**
 * 
 */
package edu.rice.jz52.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.rice.jz52.client.View2HumanPlayerService;
import edu.rice.jz52.shared.IRejectCommand;

/**
 * @author jz52@rice.edu
 *
 */
public class View2HumanPlayerServiceImpl extends RemoteServiceServlet implements
		View2HumanPlayerService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7311895970371395116L;

	/* (non-Javadoc)
	 * @see edu.rice.jz52.client.View2HumanPlayerService#setTokenAt(int, int, edu.rice.jz52.shared.IRejectCommand)
	 */
	@Override
	public void setTokenAt(int row, int column, IRejectCommand rejectCommand) {
		// TODO Auto-generated method stub
		
	}

}
