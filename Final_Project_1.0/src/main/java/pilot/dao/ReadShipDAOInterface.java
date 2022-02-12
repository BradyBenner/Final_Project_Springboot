/**
 * 
 */
package pilot.dao;

import java.util.List;

import pilot.entity.Ship;

/**
 * @author bbenner
 *
 */
public interface ReadShipDAOInterface {
	List<Ship> fetchShips(String name);
 }
