package kodlamaio.Hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceDto {
	private int id;
	private int resumeId;
	private int jobTitleId;
	private String companyName;
	private Date startedDate;
	private Date endedDate;
	private Date createdDate;
}
