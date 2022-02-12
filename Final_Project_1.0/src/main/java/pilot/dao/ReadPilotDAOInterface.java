package pilot.dao;

import java.util.List;

import pilot.entity.Pilot;

/**
 * @author bbenner
 *
 */
public interface ReadPilotDAOInterface {
	List<Pilot> fetchPilots(String first_name, String last_name);
 }
