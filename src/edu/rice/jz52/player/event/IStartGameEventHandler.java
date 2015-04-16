/**
 * 
 */
package edu.rice.jz52.player.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author jz52@rice.edu
 *
 */
public interface IStartGameEventHandler extends EventHandler {

	void onStartGame(StartGameEvent event);
	
}
