package pilot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pilot.dao.ReadMissionDAO;
import pilot.entity.Mission;

@Service
@Slf4j
public class ReadMissionService implements ReadMissionServiceInterface {

	//@Override
	@Autowired
	private ReadMissionDAO readMissionDao;
	public List<Mission> fetchMissions(String name) {
		log.info("Service:Name= {}",name);
		return readMissionDao.fetchMissions(name);
	}

}
