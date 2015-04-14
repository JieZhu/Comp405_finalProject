/**
 * 
 */
package edu.rice.jz52.shared.request;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

import edu.rice.jz52.server.domain.Cell;
import edu.rice.jz52.shared.stub.CellProxy;

/**
 * Every proxy has to be referenced as an argument or return type in one of the RequestContext methods for 
 * a given RequestFactory, otheriwse it cannot be created, because the RequestFactory does not "know" about it.
 * @author jz52@rice.edu
 *
 */
@Service(Cell.class)
public interface CellRequest extends RequestContext {

	Request<CellProxy> findCell(Long id);
//	InstanceRequest<CellProxy, Void> persist();
//	InstanceRequest<CellProxy, Void> remove();
	
}
