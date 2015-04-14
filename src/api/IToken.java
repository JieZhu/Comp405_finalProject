/**
 * 
 */
package api;

import java.io.Serializable;
import java.util.List;

/**
 * A token contains a list of active games in the system and an ordered table
 * of the player and their current games.
 * We assume that we use urls as the unique identifier of each game.
 * @author jz52@rice.edu
 *
 */
public interface IToken extends Serializable{
	
	/**
	 * get url of the game which next player is in.
	 * @return url of the game next player is in.
	 */
	String getNextGame();
	
	/**
	 * get the current player playing the game which hold the token.
	 * @return the current player.
	 */
	IPlayer getCurrentPlayer();

	/**
	 * get the active games in the system.
	 * @return list of ursl of all active games.
	 */
	List<String> getActiveGames();
}
