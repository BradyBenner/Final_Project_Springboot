package pilot.service;

import pilot.entity.Pilot;
import pilot.entity.PilotRequest;

public interface UpdatePilotService_Interface {

	 Pilot updatePilot(int pilot_Id, PilotRequest pilotRequest);

}
