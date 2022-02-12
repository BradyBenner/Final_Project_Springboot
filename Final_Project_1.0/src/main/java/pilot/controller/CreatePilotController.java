package pilot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pilot.entity.Pilot;
import pilot.entity.PilotRequest;
import pilot.service.CreatePilotService;


@RestController
@Slf4j
public class CreatePilotController implements CreatePilotController_Interface {

	@Autowired
	private CreatePilotService createPilotService;
	
	@Override
	public Pilot createPilot(PilotRequest pilotRequest) {
		log.info("Controller = {}", pilotRequest);
		return createPilotService.updatePilot(pilotRequest);
	}

}
