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
import pilot.entity.Mission;

@Service
@Slf4j
public class ReadMissionDAO implements ReadMissionDAOInterface {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Override
	public List<Mission> fetchMissions(String name) {
		log.info("DAO: Name= {}", name);
		String sql = ""+ "Select * "
		+ " from missions " 
		+ " where name = :name ";
		
		Map<String, Object> parms = Map.of("name", name);
		
		return jdbcTemplate.query(sql,parms,new RowMapper<Mission>() {

			@Override
			public Mission mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Mission.builder()
						.mission_Id(rs.getInt("mission_id"))
						.name(rs.getString("name"))
						.location(rs.getString("location"))
						.build();
			}});
	}

}
