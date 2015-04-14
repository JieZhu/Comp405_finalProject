/**
 * 
 */
package edu.rice.jz52.client.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author jz52@rice.edu
 *
 */
public class StartGameEvent extends GwtEvent<IStartGameEventHandler> {
	
	public static Type<IStartGameEventHandler> TYPE = new Type<IStartGameEventHandler>();
	
	private int rows;
	private int columns;
	
	public StartGameEvent(int rows, int columns) {
		super();
		this.rows = rows;
		this.columns = columns;
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.event.shared.GwtEvent#getAssociatedType()
	 */
	@Override
	public GwtEvent.Type<IStartGameEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.event.shared.GwtEvent#dispatch(com.google.gwt.event.shared.EventHandler)
	 */
	@Override
	protected void dispatch(IStartGameEventHandler handler) {
		// TODO Auto-generated method stub
		handler.onStartGame(this);
	}

	/**
	 * this a getter method for field rows
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * this a getter method for field columns
	 * @return the columns
	 */
	public int getColumns() {
		return columns;
	}

}
