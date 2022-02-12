package pilot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pilot.entity.Pilot;
@Service
@Slf4j
public class ReadPilotDAO implements ReadPilotDAOInterface {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Override
	public List<Pilot> fetchPilots(String first_name, String last_name) {
		log.info("DAO: First Name= {}, Last Name = {}", first_name, last_name);
		String sql = ""+ "Select * "
		+ " from pilots " 
		+ " where first_name = :first_name "
		+ " and last_name = :last_name";
		
		Map<String, Object> parms = Map.of("first_name", first_name, "last_name", last_name);
		
		return jdbcTemplate.query(sql,parms,new RowMapper<Pilot>() {

			@Override
			public Pilot mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Pilot.builder()
						.first_Name(rs.getString("first_name"))
						.last_Name(rs.getString("last_name"))
						.license(rs.getString("license"))
						.pilot_Id(rs.getInt("pilot_id"))
						.build();
			}});
	}

}
