package pilot.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import pilot.dao.CreatePilotDao;
import pilot.entity.Pilot;
import pilot.entity.PilotRequest;


@Slf4j
@Service
public class CreatePilotService implements CreatePilotService_Interface {

	@Autowired
	private CreatePilotDao createPilotDao;

	@Override
	@Transactional
	public Pilot updatePilot(PilotRequest pilotRequest) {
		log.info("Service = {}", pilotRequest);
		
		String first_name = pilotRequest.getFirst_name();
		String last_name = pilotRequest.getLast_name();
		String license = pilotRequest.getLicense();


		
		
		return createPilotDao.savePilot(first_name,last_name, license);
	}



}
