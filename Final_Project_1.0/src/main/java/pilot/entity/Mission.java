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
public class Mission {
  private int mission_Id;
  private String name;
  private String location;
  
  
  @JsonIgnore
  public int getMission_Id() {
	  return mission_Id;
  }
}

