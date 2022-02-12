package pilot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pilot.entity.Pilot;
import pilot.entity.PilotRequest;
import pilot.service.UpdatePilotService;


@RestController
@Slf4j
public class UpdatePilotController implements UpdatePilotController_Interface {

	@Autowired
	private UpdatePilotService updatePilotService;
	
	@Override
	public Pilot updatePilot(int pilot_Id, PilotRequest pilotRequest) {
		log.info("Controller = {}, {}", pilot_Id, pilotRequest);
		return updatePilotService.updatePilot(pilot_Id, pilotRequest);
	}

}
