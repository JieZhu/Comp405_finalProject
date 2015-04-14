/**
 * 
 */
package edu.rice.jz52.server;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Text;
import com.google.appengine.api.datastore.Transaction;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.rice.jz52.client.View2ModelService;
import edu.rice.jz52.server.model.board.GameBoard;

/**
 * @author jz52@rice.edu
 *
 */
public class View2ModelServiceImpl extends RemoteServiceServlet implements View2ModelService{
	
	private Key boardKey = KeyFactory.createKey("BoardKey", "MyBoard");

	/**
	 * 
	 */
	private static final long serialVersionUID = -1970152532512426519L;

	/* (non-Javadoc)
	 * @see edu.rice.jz52.client.View2ModelService#startGame(int, int)
	 */
	@Override
	public void initGame(int rows, int columns) {
		// TODO Auto-generated method stub
		System.out.println("starting game");
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		// delete all existing boards
		Transaction tx = datastore.beginTransaction();
		try {
			Query query = new Query("Board", boardKey);
			List<Entity> boards = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(5));
			for (Entity entity : boards) {
				datastore.delete(entity.getKey());
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error occured when attempting to delete previous boards");
		} finally {
			if (tx.isActive()) tx.rollback();
		}
		// create a new board and store it into date storage
		GameBoard gameBoard = new GameBoard(rows, columns);
		tx = datastore.beginTransaction();
		try {
			Entity board = new Entity("Board", boardKey);
			Text text = new Text(gameBoard.getState());
			board.setProperty("boardState", text);
			datastore.put(board);
			tx.commit();
		} catch (Exception e){
			System.out.println("errors occured when store the new game state.");
			e.printStackTrace();
		} finally {
			if (tx.isActive()) tx.rollback();
		}
		System.out.println("sueecssfully create a new game");
	}

	/* (non-Javadoc)
	 * @see edu.rice.jz52.client.View2ModelService#setTokenAt(api.IPlayer, int, int)
	 */
	@Override
	public void setTokenAt(int player, int row, int column) {
		// TODO Auto-generated method stub
		System.out.println("place token at row: " + row + " column: " + column);
		
		// get current game board
		
	}
}
