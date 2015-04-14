/**
 * 
 */
package edu.rice.jz52.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @author jz52@rice.edu
 *
 */
@RemoteServiceRelativePath("view2ModelService")
public interface View2ModelService extends RemoteService {
	void initGame(int row, int column);
	void setTokenAt(int player, int row, int column);
}
