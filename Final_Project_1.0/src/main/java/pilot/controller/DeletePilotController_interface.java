package pilot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import pilot.entity.Pilot;
import io.swagger.v3.oas.annotations.Parameter;

@RequestMapping("/deletepilots")


public interface DeletePilotController_interface {
	
	 @Operation(
			summary = "Deletes pilots based on a first and last name",
			description = "Deletes pilots based on a first and last name",
			responses = {
					@ApiResponse(responseCode = "200", description = "At least one Pilot was deleted", 
							content = @Content(mediaType = "application/Json", schema = @Schema(implementation = Pilot.class ))),
					@ApiResponse(responseCode = "400", description = "The request parameters are invalid", 
					content = @Content(mediaType = "application/Json")),
					@ApiResponse(responseCode = "404", description = "No Pilots are found with the input criteria", 
					content = @Content(mediaType = "application/Json")),
					@ApiResponse(responseCode = "500", description = "An unplanned error occured", 
					content = @Content(mediaType = "application/Json"))
			},
			parameters = {
					@Parameter(name= "first_name", allowEmptyValue = false, required = true, description = "The first name of the pilot"),
					@Parameter(name = "last_name", allowEmptyValue = false, required = true, description = "The last name of the pilot")
					
			}
			)
			
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.OK)
	int deletePilots(@RequestParam(required = true)  String first_name, @RequestParam(required = true) String last_name);

}
