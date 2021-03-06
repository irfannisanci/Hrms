package kodlamaio.Hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateInputDto {
	private int id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String nationalityId;
	private String birthOfDate;
}
