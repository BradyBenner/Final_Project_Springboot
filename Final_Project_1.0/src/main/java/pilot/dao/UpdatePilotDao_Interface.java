package pilot.dao;


import pilot.entity.Pilot;

public interface UpdatePilotDao_Interface {
	Pilot savePilot(int pilot_Id, String first_name, String last_name, String license);
}
