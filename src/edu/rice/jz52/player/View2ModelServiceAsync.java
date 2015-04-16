/**
 * 
 */
package edu.rice.jz52.player;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author jz52@rice.edu
 *
 */
public interface View2ModelServiceAsync {

	void initGame(int row, int column, AsyncCallback<Void> callback);

	void setTokenAt(int player, int row, int column,
			AsyncCallback<Void> callback);

}
