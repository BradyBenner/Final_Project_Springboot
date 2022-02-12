package pilot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pilot.entity.Ship;
import pilot.service.ReadShipServiceInterface;

@RestController
@Slf4j

public class ReadShipController implements ReadShipController_interface {

	@Autowired
	private ReadShipServiceInterface readShipService;
	//@Override
	public List<Ship> fetchShips(String name) {
		log.info("Controller name = {}", name);
		return readShipService.fetchShips(name);
	}

}
