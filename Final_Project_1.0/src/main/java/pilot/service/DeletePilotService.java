package pilot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pilot.dao.DeletePilotDAO;

@Service
@Slf4j
public class DeletePilotService implements DeletePilotServiceInterface {

	//@Override
	@Autowired
	private DeletePilotDAO deletePilotDao;
	public int deletePilots(String first_name, String last_name) {
		log.info("Service: First Name= {}, Last Name = {}", first_name, last_name);
		return deletePilotDao.deletePilots(first_name, last_name);
	}

}
