package pilot.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import pilot.entity.Pilot;


@Component
public class UpdatePilotDao implements UpdatePilotDao_Interface {

	  @Autowired
	  private NamedParameterJdbcTemplate jdbcTemplate;

	  
	  @Override
		public Pilot savePilot(int pilot_Id, String first_name, String last_name, String license) {
			SqlParams sqlParams = generateInsertSql(pilot_Id, first_name, last_name, license);
		
			KeyHolder keyHolder = new GeneratedKeyHolder();
			
			int status =jdbcTemplate.update(sqlParams.sql, sqlParams.source, keyHolder);
			if(status != 0){
			      System.out.println("Pilot data updated for ID " + pilot_Id);
			    }else{
			      System.out.println("No Pilot found with ID " + pilot_Id);
			      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Pilot found with ID " + pilot_Id);
			    }  
			
			return Pilot.builder()
					.first_Name(first_name)
					.last_Name(last_name)
					.license(license)
					.build();
	  }


	  private SqlParams generateInsertSql(int pilot_Id, String first_name, String last_name, String license) {
	    // @formatter:off
	    String sql = ""
	        + "UPDATE pilots "
	        + "set first_name = :first_name, "
	        + "last_name = :last_name, "
	        + "license = :license "
	        + "where pilot_id = :pilot_id";
	    // @formatter:on
	    
	    SqlParams params = new SqlParams();
	    
	    params.sql = sql;
	    params.source.addValue("pilot_id", pilot_Id);
	    params.source.addValue("first_name", first_name);
	    params.source.addValue("last_name", last_name);
	    params.source.addValue("license", license);
	    
	    return params;
	  }

	  

	  class SqlParams {
	    String sql;
	    MapSqlParameterSource source = new MapSqlParameterSource();
	  }

	

	

}
