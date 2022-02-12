/**
 * 
 */
package pilot.service;

import java.util.List;

import pilot.entity.Pilot;

/**
 * @author bbenner
 *
 */
public interface ReadPilotServiceInterface {

	List<Pilot> fetchPilots(String first_name, String last_name);

}
