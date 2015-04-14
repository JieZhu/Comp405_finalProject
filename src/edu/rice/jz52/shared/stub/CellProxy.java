/**
 * 
 */
package edu.rice.jz52.shared.stub;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;

import edu.rice.jz52.server.domain.Cell;

/**
 * @author jz52@rice.edu
 *
 */
@ProxyFor(value = Cell.class)
public interface CellProxy extends ValueProxy {
	
	public Integer getX();
	
	public Integer getY();
	
	public Integer getValue();
	
	public String getPlayerName();
	
	public void setX(Integer x);
	
	public void setY(Integer y);
	
	public void setValue(Integer value);
	
	public void setPlayerName(String playerName);

}
