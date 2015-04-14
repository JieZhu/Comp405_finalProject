package edu.rice.jz52.server.model.board;

import java.io.Serializable;
public class Cell implements Serializable{
	private static final long serialVersionUID = -368714575936648972L;
	public int x;
	public int y;
	public int val;
	public String playerName = "None";
	  
	  public Cell() {
		  
	  }
	  
	  public Cell(int x, int y, int val, String playerNameIn) {
		  this.x = x;
		  this.y = y;
		  this.val = val;
		  this.playerName = playerNameIn;
	  }
	  
	  public Cell clone() {
		  return new Cell(x,y,val, playerName);
	  }
}
	