package pilot.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class PilotRequest {
	@NotNull
	@Length(max = 30)
	@Pattern(regexp = "[\\w\\s]*")
	private String first_name;

	
	@NotNull
	@Length(max = 30)
	@Pattern(regexp = "[\\w\\s]*")
	private String last_name;
	

	
	@NotNull
	@Length(max = 30)
	@Pattern(regexp = "[\\w\\s]*")
	private String license;

	
	
}
