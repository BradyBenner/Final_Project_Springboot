package pilot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import pilot.entity.Mission;
import io.swagger.v3.oas.annotations.Parameter;

@RequestMapping("/readmissions")

public interface ReadMissionController_interface {
	
	 @Operation(
			summary = "Returns a list of Missions",
			description = "Returns a list of Missions given a mission Name",
			responses = {
					@ApiResponse(responseCode = "200", description = "A list of Missions is returned", 
							content = @Content(mediaType = "application/Json", schema = @Schema(implementation = Mission.class ))),
					@ApiResponse(responseCode = "400", description = "The request parameters are invalid", 
					content = @Content(mediaType = "application/Json")),
					@ApiResponse(responseCode = "404", description = "No Missions are found with the input criteria", 
					content = @Content(mediaType = "application/Json")),
					@ApiResponse(responseCode = "500", description = "An unplanned error occured", 
					content = @Content(mediaType = "application/Json"))
			},
			parameters = {
					@Parameter(name= "name", allowEmptyValue = false, required = true, description = "The name of the mission")
					
			}
			)
			
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<Mission> fetchMissions(@RequestParam(required = true)  String name);

}
