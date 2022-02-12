/**
 * 
 */
package pilot.service;

import java.util.List;

import pilot.entity.Mission;

/**
 * @author bbenner
 *
 */
public interface ReadMissionServiceInterface {

	List<Mission> fetchMissions(String name);

}
