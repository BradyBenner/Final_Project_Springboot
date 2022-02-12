package pilot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pilot.service.DeletePilotServiceInterface;

@RestController
@Slf4j

public class DeletePilotController implements DeletePilotController_interface {

	@Autowired
	private DeletePilotServiceInterface deletePilotService;
	//@Override
	public int deletePilots(String first_name, String last_name) {
		log.info("Controller first_name = {}, last_name = {}", first_name, last_name);
		return deletePilotService.deletePilots(first_name, last_name);
	}

}
