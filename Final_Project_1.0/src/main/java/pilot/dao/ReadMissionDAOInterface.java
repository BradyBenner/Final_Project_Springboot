package pilot.dao;

import java.util.List;

import pilot.entity.Mission;

/**
 * @author bbenner
 *
 */
public interface ReadMissionDAOInterface {
	List<Mission> fetchMissions(String name);
 }
