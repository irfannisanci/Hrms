package kodlamaio.Hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertInputDto {
	
	private int id;
	private int employerId;
	private int jobTitleId;
	private String numberOfPosition;
	private String minSalary;
	private String maxSalary;
	private int CityId;
	private LocalDate creationDate;
	private LocalDate closeDate;
	private String description;
	private boolean isActive;
}
