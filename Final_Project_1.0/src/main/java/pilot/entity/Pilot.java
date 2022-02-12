package pilot.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pilot {
  private int pilot_Id;
  private String first_Name;
  private String last_Name;
  private String license;
  
  
  @JsonIgnore
  public int getPilot_Id() {
	  return pilot_Id;
  }
}

