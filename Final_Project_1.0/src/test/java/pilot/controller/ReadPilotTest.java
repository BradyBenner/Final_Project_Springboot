package pilot.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import pilot.entity.Pilot;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {
    "classpath:migrations/Pilot_Schema.sql",
    "classpath:migrations/Pilot_Data.sql"}, 
    config = @SqlConfig(encoding = "utf-8"))
    

class ReadPilotTest {

	@Autowired
	  private TestRestTemplate restTemplate;
	  
	  @LocalServerPort
	  private int serverPort;


	@Test
	void testThatPilotsAreReturnedWhenAValidFirstAndLastNameAreSupplied() {
		//given: valid model, trim, uri
		String first_Name = "Brady";
		String last_Name = "Benner";
		String uri = String.format("http://localhost:%d/readpilots?first_name=%s&last_name=%s", serverPort, first_Name, last_Name);
		System.out.println("Uri = "+uri);
		//when: connection is made to the uri
		ResponseEntity<List<Pilot>> response = 
				restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
		System.out.println("body = "+ response.getBody());
		//then: 200 status code is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK); 
		System.out.println("Should have modelpk = null " +response.getBody());
		
		//And: the returned jeep objects are what is expected
		assertThat(response.getBody()).isEqualTo(buildExpected());

	}
	
	private List<Pilot> buildExpected() {
		List<Pilot> pilots = new LinkedList<Pilot>();
		
		pilots.add( Pilot.builder()
				.first_Name("Brady")
				.last_Name("Benner")
				.license("ALL")
				.pilot_Id(0)
				.build());
		
		return pilots;
	}

}
