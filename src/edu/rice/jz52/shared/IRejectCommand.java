/**
 * 
 */
package edu.rice.jz52.shared;

import java.io.Serializable;

/**
 * @author jz52@rice.edu
 *
 */
public interface IRejectCommand extends Serializable{
	
	void apply();

}
