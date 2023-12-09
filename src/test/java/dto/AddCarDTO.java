package dto;

import lombok.Builder;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;


@Builder
@Getter
@Setter
@ToString

public class AddCarDTO {

  String serialNumber;
  String manufacture;
  String model;
  int year;
  String fuel;
  int seats;
  String carClass;
  double pricePerDay;
  String about;
  String city;

}
