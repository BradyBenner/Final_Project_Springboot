/**
 * 
 */
package pilot.service;

import java.util.List;

import pilot.entity.Ship;

/**
 * @author bbenner
 *
 */
public interface ReadShipServiceInterface {

	List<Ship> fetchShips(String name);

}
