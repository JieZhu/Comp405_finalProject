/**
 * 
 */
package edu.rice.jz52.player.request;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

/**
 * @author jz52@rice.edu
 *
 */
public interface RaceGameRequestFactory extends RequestFactory {

	GameBoardRequest gameBoardRequest();
}
