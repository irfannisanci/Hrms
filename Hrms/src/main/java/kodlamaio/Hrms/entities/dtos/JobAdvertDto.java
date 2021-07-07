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
	private String employerCompanyName;
	private String jobTitleTitleName;
	private LocalDate creationDate;
	private LocalDate closeDate;
	private String numberOfPosition;
}
