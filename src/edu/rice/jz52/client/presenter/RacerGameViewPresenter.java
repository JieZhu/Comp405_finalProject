/**
 * 
 */
package edu.rice.jz52.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import edu.rice.jz52.client.View2ModelServiceAsync;

/**
 * @author jz52@rice.edu
 *
 */
public class RacerGameViewPresenter implements IPresenter {
	
	/**
	 * @author jz52@rice.edu
	 *
	 */
	public interface Display {

		/**
		 * @return
		 */
		Widget asWidget();
		HasClickHandlers getButton(int row, int column);
		int getRowsNumber();
		int getColumnsNumber();
	}

	private View2ModelServiceAsync modelService;
	private EventBus eventBus;
	private Display display;
	
	public RacerGameViewPresenter(View2ModelServiceAsync modelService,
			EventBus eventBus2, Display display) {
		super();
		this.modelService = modelService;
		this.eventBus = eventBus2;
		this.display = display;
	}

	/* (non-Javadoc)
	 * @see edu.rice.jz52.client.presenter.Presenter#go(com.google.gwt.user.client.ui.HasWidgets)
	 */
	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub
		bind();
		container.clear();
		container.add(display.asWidget());
	}

	/**
	 * 
	 */
	private void bind() {
		for (int i = 0; i < display.getRowsNumber(); i++)
			for(int j = 0; j < display.getColumnsNumber(); j++){
				
				display.getButton(i, j).addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub
						
					}
				});
			}
	}

}
