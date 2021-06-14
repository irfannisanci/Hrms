package kodlamaio.Hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {
	private int id;
	private int resumeId;
	private int graduateId;
	private String graduateDescription;
	private String schoolName;
	private String schoolDepartment;
	private Date startedDate;
	private Date endedDate;
	private Date createdDate;
}
