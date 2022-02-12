package pilot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pilot.dao.ReadShipDAO;
import pilot.entity.Ship;

@Service
@Slf4j
public class ReadShipService implements ReadShipServiceInterface {

	//@Override
	@Autowired
	private ReadShipDAO readShipDao;
	public List<Ship> fetchShips(String name) {
		log.info("Service:Name= {}",name);
		return readShipDao.fetchShips(name);
	}

}
