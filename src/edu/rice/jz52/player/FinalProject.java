package edu.rice.jz52.player;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.RootPanel;

import edu.rice.jz52.player.request.RaceGameRequestFactory;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class FinalProject implements EntryPoint {
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		View2ModelServiceAsync modelService = GWT.create(View2ModelService.class);
		SimpleEventBus eventBus = new SimpleEventBus();
		
		final RaceGameRequestFactory requestFactory = GWT.create(RaceGameRequestFactory.class);
		requestFactory.initialize(new SimpleEventBus());
		
		Controller controller = new Controller(modelService, requestFactory, eventBus);
		controller.go(RootPanel.get("mainFrame"));
	}
}
