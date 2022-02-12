package pilot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import pilot.entity.Pilot;
import io.swagger.v3.oas.annotations.Parameter;

//This interface sets up the server API documentation, read pilot documentation and the read pilot
//entry point
@RequestMapping("/readpilots")
@OpenAPIDefinition(info = @Info(title = "Space Mission Pilot and Ship Assignment Application"), servers = {
		@Server(url = "http://localhost:8080", description = "Brady's Local Server.") })

public interface ReadPilotController_interface {
	
	 @Operation(
			summary = "Returns a list of Pilots",
			description = "Returns a list of Pilots given a First or Last Name",
			responses = {
					@ApiResponse(responseCode = "200", description = "A list of Pilots is returned", 
							/* Need to fix Jeep.class below!!!!*/
							content = @Content(mediaType = "application/Json", schema = @Schema(implementation = Pilot.class ))),
					@ApiResponse(responseCode = "400", description = "The request parameters are invalid", 
					content = @Content(mediaType = "application/Json")),
					@ApiResponse(responseCode = "404", description = "No Pilots are found with the input criteria", 
					content = @Content(mediaType = "application/Json")),
					@ApiResponse(responseCode = "500", description = "An unplanned error occured", 
					content = @Content(mediaType = "application/Json"))
			},
			parameters = {
					/* need to fix parameters below !!!! */
					@Parameter(name= "first_name", allowEmptyValue = false, required = true, description = "The first name of the pilot"),
					@Parameter(name = "last_name", allowEmptyValue = false, required = true, description = "The last name of the pilot")
					
			}
			)
			
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)

	List<Pilot> fetchPilots(@RequestParam(required = true)  String first_name, @RequestParam(required = true) String last_name);

}
