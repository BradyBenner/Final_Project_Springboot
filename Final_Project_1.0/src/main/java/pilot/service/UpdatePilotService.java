package pilot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import pilot.dao.UpdatePilotDao;
import pilot.entity.Pilot;
import pilot.entity.PilotRequest;


@Slf4j
@Service
public class UpdatePilotService implements UpdatePilotService_Interface {

	@Autowired
	private UpdatePilotDao updatePilotDao;

	@Override
	@Transactional
	public Pilot updatePilot(int pilot_Id, PilotRequest pilotRequest) {
		log.info("Service = {}, {}", pilot_Id, pilotRequest);
		
		String first_name = pilotRequest.getFirst_name();
		String last_name = pilotRequest.getLast_name();
		String license = pilotRequest.getLicense();

		
		return updatePilotDao.savePilot(pilot_Id, first_name,last_name, license);
	}



}
