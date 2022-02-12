package pilot.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import pilot.entity.Pilot;


@Component
public class CreatePilotDao implements CreatePilotDao_Interface {

	  @Autowired
	  private NamedParameterJdbcTemplate jdbcTemplate;

	  
	  @Override
		public Pilot savePilot(String first_name, String last_name, String license) {
			SqlParams sqlParams = generateInsertSql(first_name, last_name, license);
		
			KeyHolder keyHolder = new GeneratedKeyHolder();
			
			jdbcTemplate.update(sqlParams.sql, sqlParams.source, keyHolder);
			int pilot_Id =keyHolder.getKey().intValue();
			System.out.println("Created pilot ID = " + pilot_Id);
			
			return Pilot.builder()
					.first_Name(first_name)
					.last_Name(last_name)
					.license(license)
					.build();
	  }

	  private SqlParams generateInsertSql(String first_name, String last_name, String license) {
	    // @formatter:off
	    String sql = ""
	        + "INSERT INTO pilots ("
	        + "first_name,last_name,license"
	        + ") VALUES ("
	        + ":first_name, :last_name, :license"
	        + ")";
	    // @formatter:on
	    
	    SqlParams params = new SqlParams();
	    
	    params.sql = sql;
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
