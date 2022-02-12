package pilot.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import pilot.entity.Pilot;
import pilot.entity.PilotRequest;

@RequestMapping("/updatepilot")
@Validated 
public interface UpdatePilotController_Interface {
	
	@Operation(
			summary = "Update a pilot with the specified First and Last Name and License given a pilot ID "
					+ "primary key value",
			description =  "Update a pilot with the specified First and Last Name and License given a pilot ID "
					+ "primary key value",
			responses = {
					@ApiResponse(responseCode = "201", description = "At least one Pilot was updated", 
							
							content = @Content(mediaType = "application/Json", schema = @Schema(implementation = Pilot.class ))),
					@ApiResponse(responseCode = "400", description = "The request parameters are invalid", 
					content = @Content(mediaType = "application/Json")),
					@ApiResponse(responseCode = "500", description = "An unplanned error occured", 
					content = @Content(mediaType = "application/Json"))
			},
			parameters = {
					
					@Parameter(name= "pilot_Id", allowEmptyValue = false, required = false, 
							description = "The pilot id of the pilot to be updated"),			
			}
			)
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	Pilot updatePilot(@RequestParam int pilot_Id,  @Valid @RequestBody PilotRequest order);

}
