/**
 * 
 */
package edu.rice.jz52.player.presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.ConstraintViolation;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dev.jjs.impl.GwtAstBuilder;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

import edu.rice.jz52.player.View2ModelServiceAsync;
import edu.rice.jz52.player.event.StartGameEvent;
import edu.rice.jz52.player.request.GameBoardRequest;
import edu.rice.jz52.player.request.RaceGameRequestFactory;
import edu.rice.jz52.player.stub.GameBoardProxy;

/**
 * @author jz52@rice.edu
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
		
		display.getResetButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				String host = GWT.getModuleBaseURL() + "gameView";
				logger.log(Level.INFO, host);
				RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, host);
				try {
					requestBuilder.sendRequest(null, new RequestCallback() {
						
						@Override
						public void onResponseReceived(com.google.gwt.http.client.Request request,
								Response response) {
							// TODO Auto-generated method stub
							if (response.getStatusCode() == 200) {
//								  final TabPanel tab = new TabPanel();
//							      final FlowPanel xmlSource = new FlowPanel();
//							      tab.add(xmlSource, "Details");
//							      tab.selectTab(0);
//							      RootPanel.get().add(tab);
//							      xmlPane(xmlText, xmlSource);
								Window.alert("Successfull ");
							} else {
								logger.log(Level.WARNING, "on received" + response.getStatusCode());
							}
						}
						
						@Override
						public void onError(com.google.gwt.http.client.Request request,
								Throwable exception) {
							// TODO Auto-generated method stub
							logger.log(Level.WARNING, "on error");
							exception.printStackTrace();
						}
					});
				} catch (RequestException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
	}

}
