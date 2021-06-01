package kodlamaio.Hrms.entities.dtos;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertDto {
	private int id;
	private String companyName;
	private String email;
	private String webAddress;
	private String phoneNumber;
	private String cityName;
	private String titleName;
	private boolean isActive;
	private LocalDate creationDate;
	private LocalDate applicationDeadline;
	private String minSalary;
	private String maxSalary;
	private String numberOfPosition;
}
