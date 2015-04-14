/**
 * 
 */
package edu.rice.jz52.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.rice.jz52.shared.IRejectCommand;

/**
 * @author jz52@rice.edu
 *
 */
public interface View2HumanPlayerServiceAsync {

	void setTokenAt(int row, int column, IRejectCommand rejectCommand,
			AsyncCallback<Void> callback);

}
