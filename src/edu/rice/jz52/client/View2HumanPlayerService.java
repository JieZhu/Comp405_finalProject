/**
 * 
 */
package edu.rice.jz52.client;


import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.rice.jz52.shared.IRejectCommand;

/**
 * @author jz52@rice.edu
 *
 */
@RemoteServiceRelativePath("view2HumanPlayerService")
public interface View2HumanPlayerService extends RemoteService {
	
	void setTokenAt(int row, int column, final IRejectCommand rejectCommand);

}
