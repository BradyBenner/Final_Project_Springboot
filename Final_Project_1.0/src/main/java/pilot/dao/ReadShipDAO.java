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
import pilot.entity.Ship;

@Service
@Slf4j
public class ReadShipDAO implements ReadShipDAOInterface {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Override
	public List<Ship> fetchShips(String name) {
		log.info("DAO: Name= {}", name);
		String sql = ""+ "Select * "
		+ " from ships " 
		+ " where name = :name ";
		
		Map<String, Object> parms = Map.of("name", name);
		
		return jdbcTemplate.query(sql,parms,new RowMapper<Ship>() {

			@Override
			public Ship mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Ship.builder()
						.ship_Id(rs.getInt("ship_id"))
						.name(rs.getString("name"))
						.pilot_Id(rs.getInt("pilot_id"))
						.build();
			}});
	}

}
