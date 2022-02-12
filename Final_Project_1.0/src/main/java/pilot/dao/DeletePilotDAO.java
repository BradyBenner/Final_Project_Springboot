package pilot.dao;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DeletePilotDAO implements DeletePilotDAOInterface {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Override
	public int deletePilots(String first_name, String last_name) {
		log.info("DAO: First Name= {}, Last Name = {}", first_name, last_name);
		String sql = ""+ "DELETE"
		+ " from pilots " 
		+ " where first_name = :first_name "
		+ " and last_name = :last_name";
		
		Map<String, Object> parms = Map.of("first_name", first_name, "last_name", last_name);
		int row = jdbcTemplate.update(sql,parms);
		if(row != 0){
		      System.out.println(row+ " Pilots deleted.");
		    }else{
		      System.out.println("No Pilot found with first name = "+first_name +" and last name=  " + last_name);
		      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Pilot found with first name = "+first_name +" and last name=  " 
		      + last_name);
		    }  

		return row;

	}

}
