/**
 * 
 */
package edu.rice.jz52.player.stub;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

import edu.rice.jz52.server.domain.GameBoard;

/**
 * @author jz52@rice.edu
 *
 */
@ProxyFor(value = GameBoard.class)
public interface GameBoardProxy extends EntityProxy {
	
	/**
	 * this a getter method for field id
	 * @return the id
	 */
	public Long getId();

	/**
	 * this a getter method for field version
	 * @return the version
	 */
	public Integer getVersion();

	/**
	 * this a getter method for field rowNumber
	 * @return the rowNumber
	 */
	public Integer getRowNumber();

	/**
	 * this a getter method for field columnNumber
	 * @return the columnNumber
	 */
	public Integer getColumnNumber();

	/**
	 * this is a setter method for field rowNumber
	 * @param rowNumber the rowNumber to set
	 */
	public void setRowNumber(Integer rowNumber);

	/**
	 * this is a setter method for field columnNumber
	 * @param columnNumber the columnNumber to set
	 */
	public void setColumnNumber(Integer columnNumber);

	/**
	 * this a getter method for field cells
	 * @return the cells
	 */
	public List<Integer> getCells();
	
	/**
	 * this is a setter method for field cells
	 * @param cells the cells to set
	 */
	public void setCells(List<Integer> cells);
	
}
