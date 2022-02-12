package pilot.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import pilot.entity.Pilot;
import pilot.entity.PilotRequest;

@RequestMapping("/createpilot")
@Validated 
public interface CreatePilotController_Interface {
	
	@Operation(
			summary = "Creates a pilot with the specified First and Last Name and License",
			description = "Creates a pilot with the specified First and Last Name and License",
			responses = {
					@ApiResponse(responseCode = "201", description = "A Pilot was created", 
							
							content = @Content(mediaType = "application/Json", schema = @Schema(implementation = Pilot.class ))),
					@ApiResponse(responseCode = "400", description = "The request parameters are invalid", 
					content = @Content(mediaType = "application/Json")),
					@ApiResponse(responseCode = "500", description = "An unplanned error occured", 
					content = @Content(mediaType = "application/Json"))
			}
			)
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	Pilot createPilot(@Valid @RequestBody PilotRequest order);

}
