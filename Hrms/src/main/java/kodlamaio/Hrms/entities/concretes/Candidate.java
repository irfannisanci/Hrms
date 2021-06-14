package kodlamaio.Hrms.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.Hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name="candidates")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resums"})
public class Candidate extends User{
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private String nationalityId;
	
	@Column(name="birth_year")
	private String birthOfDate;
	
	@OneToMany(mappedBy = "candidate")
	private List<Resume> resums;

}
