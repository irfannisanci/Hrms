package kodlamaio.Hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateOutputDto {
	private int id;
	private String email;
	private String firstName;
	private String lastName;
	private String nationalityId;
	private String birthOfDate;
}
