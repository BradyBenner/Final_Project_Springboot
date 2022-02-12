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
import pilot.entity.Ship;
import io.swagger.v3.oas.annotations.Parameter;

@RequestMapping("/readships")

public interface ReadShipController_interface {
	
	 @Operation(
			summary = "Returns a list of Ships",
			description = "Returns a list of Ships given a ship Name",
			responses = {
					@ApiResponse(responseCode = "200", description = "A list of Ships is returned", 
							/* Need to fix Jeep.class below!!!!*/
							content = @Content(mediaType = "application/Json", schema = @Schema(implementation = Ship.class ))),
					@ApiResponse(responseCode = "400", description = "The request parameters are invalid", 
					content = @Content(mediaType = "application/Json")),
					@ApiResponse(responseCode = "404", description = "No Ships are found with the input criteria", 
					content = @Content(mediaType = "application/Json")),
					@ApiResponse(responseCode = "500", description = "An unplanned error occured", 
					content = @Content(mediaType = "application/Json"))
			},
			parameters = {
					@Parameter(name= "name", allowEmptyValue = false, required = true, description = "The name of the ship")
					
			}
			)
			
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<Ship> fetchShips(@RequestParam(required = true)  String name);

}
