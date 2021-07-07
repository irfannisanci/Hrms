package kodlamaio.Hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {
	
	private int id;
	private int candidateId;
	private String githubLink;
	private String linkedinLink;
	private String photo;
	private String description;
	private Date createdDate;
	private Date updatedDate;
}
