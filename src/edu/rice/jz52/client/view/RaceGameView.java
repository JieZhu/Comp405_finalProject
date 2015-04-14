/**
 * 
 */
package edu.rice.jz52.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLTable.CellFormatter;

import edu.rice.jz52.client.presenter.RacerGameViewPresenter;

/**
 * @author jz52@rice.edu
 *
 */
public class RaceGameView extends Composite implements RacerGameViewPresenter.Display{

	private final static int DEFAULT_ROWS_NUMBER = 5;
	private final static int DEFAULT_COLUMNS_NUMBER = 5;
	
	private Grid gameBoard;
	private int rows;
	private int columns; 

	public RaceGameView(int rows, int columns) {
//		this.rows = rows;
//		this.columns  = columns;
		gameBoard = new Grid(rows, columns);
		initWidget(gameBoard);
		CellFormatter cellFormatter = gameBoard.getCellFormatter();
		gameBoard.setStyleName("grid");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				cellFormatter.setHeight(i, j, "50px");
				cellFormatter.setWidth(i, j, "50px");
				Button button = new Button();
				button.setSize("50px", "50px");
				gameBoard.setWidget(i, j, button);
			}
		}
	}

	/**
	 * constructor method of RaceGameView.java
	 */
	public RaceGameView() {
		this(DEFAULT_ROWS_NUMBER, DEFAULT_COLUMNS_NUMBER);
	}

	/* (non-Javadoc)
	 * @see edu.rice.jz52.client.presenter.RacerGameViewPresenter.Display#getButton(int, int)
	 */
	@Override
	public HasClickHandlers getButton(int row, int column) {
		return (HasClickHandlers) gameBoard.getWidget(row, column);
	}

	/* (non-Javadoc)
	 * @see edu.rice.jz52.client.presenter.RacerGameViewPresenter.Display#getRowsNumber()
	 */
	@Override
	public int getRowsNumber() {
		// TODO Auto-generated method stub
		return rows;
	}

	/* (non-Javadoc)
	 * @see edu.rice.jz52.client.presenter.RacerGameViewPresenter.Display#getColumnsNumber()
	 */
	@Override
	public int getColumnsNumber() {
		// TODO Auto-generated method stub
		return columns;
	}
}
