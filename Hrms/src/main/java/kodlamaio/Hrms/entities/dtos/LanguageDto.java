package kodlamaio.Hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDto {
	private int id;
	private int resumeId;
	private String language;
	private char langLevel;
	private Date createdDate;
}
