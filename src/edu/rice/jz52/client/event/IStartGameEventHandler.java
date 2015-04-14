/**
 * 
 */
package edu.rice.jz52.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author jz52@rice.edu
 *
 */
public interface IStartGameEventHandler extends EventHandler {

	void onStartGame(StartGameEvent event);
	
}
