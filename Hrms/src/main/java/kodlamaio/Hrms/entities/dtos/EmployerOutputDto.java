package kodlamaio.Hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerOutputDto {
	private int id;
	private String email;
	private String companyName;
	private String webAddress;
	private String phoneNumber;
}

