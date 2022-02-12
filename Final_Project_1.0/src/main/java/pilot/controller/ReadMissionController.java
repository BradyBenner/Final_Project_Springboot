package pilot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pilot.entity.Mission;
import pilot.service.ReadMissionServiceInterface;

@RestController
@Slf4j

public class ReadMissionController implements ReadMissionController_interface {

	@Autowired
	private ReadMissionServiceInterface readMissionService;
	//@Override
	public List<Mission> fetchMissions(String name) {
		log.info("Controller name = {}", name);
		return readMissionService.fetchMissions(name);
	}

}
