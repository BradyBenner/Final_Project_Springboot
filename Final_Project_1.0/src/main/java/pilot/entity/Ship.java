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
public class Ship {
  private int ship_Id;
  private String name;
  private int pilot_Id;
  
  
  @JsonIgnore
  public int getShip_Id() {
	  return ship_Id;
  }
}

