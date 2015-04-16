/**
 * 
 */
package edu.rice.jz52.player.request;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

import edu.rice.jz52.player.stub.GameBoardProxy;
import edu.rice.jz52.server.domain.GameBoard;

/**
 * @author jz52@rice.edu
 *
 */
@Service(GameBoard.class)
public interface GameBoardRequest extends RequestContext {

	Request<GameBoardProxy> findGameBoard(Long id);
	
	InstanceRequest<GameBoardProxy, Void> persist();
	
	InstanceRequest<GameBoardProxy, Void> remove();
	
}
