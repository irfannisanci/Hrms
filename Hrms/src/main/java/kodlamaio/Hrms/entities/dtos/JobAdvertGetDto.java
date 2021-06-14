package kodlamaio.Hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertGetDto {
	private int id;
	private int jobTitleId;
	private String jobTitleTitleName; 
	private int cityId;
	private String cityCityName;
	private int employerId;
	private String employerCompanyName;
	private String employerWebAddress;
	private String employerPhoneNumber;
	private String employerEmail;
	private LocalDate creationDate;
	private LocalDate closeDate;
	private boolean isActive;
	private String jobDescription;
	private String minSalary;
	private String maxSalary;
	private String numberOfPosition;
}
