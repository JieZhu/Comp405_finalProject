/**
 * 
 */
package edu.rice.jz52.player.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.rice.jz52.player.presenter.MainPresenter;

/**
 * @author jz52@rice.edu
 *
 */
public class MainView extends Composite implements MainPresenter.Display {

	private VerticalPanel panel = new VerticalPanel();

	private Button startButton = new Button("Start");
	private Button resetButton = new Button("Reset");
	private Button undoButton = new Button("Undo");
	private VerticalPanel controlPanel = new VerticalPanel();
	
	private TextBox rowsNumberBox = new TextBox();
	private TextBox columnsNumberBox = new TextBox();

	public MainView() {
		initWidget(panel);
		
		// TODO configure control panel
		controlPanel.add(rowsNumberBox);
		controlPanel.add(columnsNumberBox);
		controlPanel.add(startButton);
		controlPanel.add(resetButton);
		controlPanel.add(undoButton);

		panel.add(controlPanel);
	}

	public Widget asWidget() {
		return this;
	}

	/* (non-Javadoc)
	 * @see edu.rice.jz52.client.presenter.MainPresenter.Display#getStartButton()
	 */
	@Override
	public HasClickHandlers getStartButton() {
		// TODO Auto-generated method stub
		return startButton;
	}

	/* (non-Javadoc)
	 * @see edu.rice.jz52.client.presenter.MainPresenter.Display#getResetButton()
	 */
	@Override
	public HasClickHandlers getResetButton() {
		// TODO Auto-generated method stub
		return resetButton;
	}

	/* (non-Javadoc)
	 * @see edu.rice.jz52.client.presenter.MainPresenter.Display#getUndoButton()
	 */
	@Override
	public HasClickHandlers getUndoButton() {
		// TODO Auto-generated method stub
		return undoButton;
	}

	/* (non-Javadoc)
	 * @see edu.rice.jz52.client.presenter.MainPresenter.Display#getRows()
	 */
	@Override
	public int getRows() {
		// TODO Auto-generated method stub
		return Integer.parseInt(rowsNumberBox.getText());
	}

	/* (non-Javadoc)
	 * @see edu.rice.jz52.client.presenter.MainPresenter.Display#getColumns()
	 */
	@Override
	public int getColumns() {
		// TODO Auto-generated method stub
		return Integer.parseInt(columnsNumberBox.getText());
	}
}
