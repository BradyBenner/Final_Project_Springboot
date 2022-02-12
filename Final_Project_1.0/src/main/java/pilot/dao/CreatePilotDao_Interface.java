package pilot.dao;


import pilot.entity.Pilot;

public interface CreatePilotDao_Interface {

	Pilot savePilot(String first_name, String last_name, String license);
}
