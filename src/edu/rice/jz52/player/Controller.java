/**
 * 
 */
package edu.rice.jz52.player;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

import edu.rice.jz52.player.event.IStartGameEventHandler;
import edu.rice.jz52.player.event.StartGameEvent;
import edu.rice.jz52.player.presenter.IPresenter;
import edu.rice.jz52.player.presenter.MainPresenter;
import edu.rice.jz52.player.presenter.RacerGameViewPresenter;
import edu.rice.jz52.player.request.RaceGameRequestFactory;
import edu.rice.jz52.player.view.MainView;
import edu.rice.jz52.player.view.RaceGameView;

/**
 * @author jz52@rice.edu
 *
 */
public class Controller implements IPresenter, ValueChangeHandler<String> {
	
	private View2ModelServiceAsync modelService;
	private SimpleEventBus eventBus;
	private HasWidgets container;
	private RaceGameRequestFactory requestFactory;

	public Controller(View2ModelServiceAsync modelService, RaceGameRequestFactory requestFactory, SimpleEventBus eventBus2){
		this.modelService = modelService;
		this.eventBus = eventBus2;
		this.requestFactory = requestFactory;
		History.addValueChangeHandler(this);
		bind();
	}

	/**
	 * 
	 */
	private void bind() {
		// configure event bus add events and their listeners
		eventBus.addHandler(StartGameEvent.TYPE, new IStartGameEventHandler() {
			
			@Override
			public void onStartGame(StartGameEvent event) {
				// TODO Auto-generated method stub
				History.newItem("game", false);
				IPresenter presenter = new RacerGameViewPresenter(modelService, eventBus, new RaceGameView(event.getRows(), event.getColumns()));
				presenter.go(container);
			}
		});
	}

	/* (non-Javadoc)
	 * @see edu.rice.jz52.client.presenter.Presenter#go(com.google.gwt.user.client.ui.HasWidgets)
	 */
	@Override
	public void go(HasWidgets container) {
		this.container = container;
	    if ("".equals(History.getToken())) {
	      History.newItem("main");
	    }
	    else {
	      History.fireCurrentHistoryState();
	    }
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.event.logical.shared.ValueChangeHandler#onValueChange(com.google.gwt.event.logical.shared.ValueChangeEvent)
	 */
	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		// TODO Auto-generated method stub
		String token = event.getValue();
		if (token != null){
			IPresenter presenter = null;
			if(token == "main"){
				presenter = new MainPresenter(modelService, requestFactory, eventBus, new MainView());
//				presenter.go(container);
			} else if (token == "game") {
				presenter = new RacerGameViewPresenter(modelService, eventBus, new RaceGameView());
//				presenter.go(container);
			}
			if (presenter != null){
				presenter.go(container);
			}
		}
	}

}
