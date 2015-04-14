/**
 * 
 */
package edu.rice.jz52.server.domain;



/**
 * @author jz52@rice.edu
 */
public class Cell {

	public Integer x;
	public Integer y;
	public Integer value;
	public String playerName;
	
	public Integer getX() {
		return x;
	}
	
	public Integer getY() {
		return y;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setX(Integer x) {
		this.x = x;
	}
	
	public void setY(Integer y) {
		this.y = y;
	}
	
	public void setValue(Integer value) {
		this.value = value;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public static Cell findCell(Long id) {
		return new Cell();
	}
}
