package pilot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pilot.dao.ReadPilotDAO;
import pilot.entity.Pilot;

@Service
@Slf4j
public class ReadPilotService implements ReadPilotServiceInterface {

	//@Override
	@Autowired
	private ReadPilotDAO readPilotDao;
	public List<Pilot> fetchPilots(String first_name, String last_name) {
		log.info("Service: First Name= {}, Last Name = {}", first_name, last_name);
		return readPilotDao.fetchPilots(first_name, last_name);
	}

}
