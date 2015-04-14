/**
 * 
 */
package edu.rice.jz52.client.presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.ConstraintViolation;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

import edu.rice.jz52.client.View2ModelServiceAsync;
import edu.rice.jz52.client.event.StartGameEvent;
import edu.rice.jz52.shared.request.GameBoardRequest;
import edu.rice.jz52.shared.request.RaceGameRequestFactory;
import edu.rice.jz52.shared.stub.GameBoardProxy;

/**
 * @author jz52@rice.edu
 *
 */
public class MainPresenter implements IPresenter{
	
	public interface Display {

		/**
		 * @return
		 */
		Widget asWidget();
		HasClickHandlers getStartButton();
		HasClickHandlers getResetButton();
		HasClickHandlers getUndoButton();
		/**
		 * @return
		 */
		int getRows();
		/**
		 * @return
		 */
		int getColumns();
		
	}
	private Display display;
	private View2ModelServiceAsync modelService;
	private EventBus eventBus;
	private RaceGameRequestFactory requestFactory;
	
	private Logger logger = Logger.getLogger("MainPresenter.class");
	
	public MainPresenter(View2ModelServiceAsync modelService,
			RaceGameRequestFactory requestFactory, EventBus eventBus2, Display display) {
		super();
		this.modelService = modelService;
		this.eventBus = eventBus2;
		this.display = display;
		this.requestFactory = requestFactory;
		bind();
	}


	/* (non-Javadoc)
	 * @see edu.rice.jz52.client.presenter.Presenter#go(com.google.gwt.user.client.ui.HasWidgets)
	 */
	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
		//TODO initialize view data
	}

	/**
	 * bind function to add listeners to events in the view.
	 */
	private void bind() {
		// TODO Auto-generated method stub
		display.getStartButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
//				AsyncCallback<Void> callback = new AsyncCallback<Void>() {
//
//					@Override
//					public void onFailure(Throwable caught) {
//						// TODO Auto-generated method stub
//						caught.printStackTrace();
//					}
//
//					@Override
//					public void onSuccess(Void result) {
//						// TODO Auto-generated method stub
//						System.out.println("game started.");
//					}
//				};
//				modelService.initGame(display.getRows(), display.getColumns(), callback);
//				eventBus.fireEvent(new StartGameEvent(5, 5));
				
				logger.log(Level.INFO, "On click start button in welcome page");
				GameBoardRequest gameBoardRequest = requestFactory.gameBoardRequest();
				GameBoardProxy gameBoardProxy = gameBoardRequest.create(GameBoardProxy.class);
				final int row = display.getRows();
				final int column = display.getColumns();
				gameBoardProxy.setRowNumber(new Integer(row));
				gameBoardProxy.setColumnNumber(new Integer(column));
				
				List<Integer> cells = new ArrayList<Integer>();
				for (int i = 0; i < row * column - 1; i++) {
					cells.add(new Integer(0)); //no value initialization
				}
				gameBoardProxy.setCells(cells);
				
				Request<Void> request = gameBoardRequest.persist().using(gameBoardProxy);
				request.fire(new Receiver<Void>() {

					@Override
					public void onSuccess(Void response) {
						logger.log(Level.INFO, "request.fire() on success");
						eventBus.fireEvent(new StartGameEvent(5, 5));
					}

					/* (non-Javadoc)
					 * @see com.google.web.bindery.requestfactory.shared.Receiver#onFailure(com.google.web.bindery.requestfactory.shared.ServerFailure)
					 */
					@Override
					public void onFailure(ServerFailure error) {
						super.onFailure(error);
						logger.log(Level.WARNING, "request.fire() on failure");
					}

					/* (non-Javadoc)
					 * @see com.google.web.bindery.requestfactory.shared.Receiver#onConstraintViolation(java.util.Set)
					 */
					@Override
					public void onConstraintViolation(
							Set<ConstraintViolation<?>> violations) {
						super.onConstraintViolation(violations);
						logger.log(Level.WARNING, "request.fire() on constraint violation");
					}
					
				});
			}
		});
		
	}

}
