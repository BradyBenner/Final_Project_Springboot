package pilot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pilot.entity.Pilot;
import pilot.service.ReadPilotServiceInterface;

@RestController
@Slf4j

public class ReadPilotController implements ReadPilotController_interface {

	@Autowired
	private ReadPilotServiceInterface readPilotService;
	//@Override
	public List<Pilot> fetchPilots(String first_name, String last_name) {
		log.info("Controller first_name = {}, last_name = {}", first_name, last_name);
		return readPilotService.fetchPilots(first_name, last_name);
	}

}
