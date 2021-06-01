package kodlamaio.Hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_adverts")
public class JobAdvert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="creation_date")
	private LocalDate creationDate;
	
	@Column(name="application_deadline")
	private LocalDate applicationDeadline;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="min_salary")
	private String minSalary;
	
	@Column(name="max_salary")
	private String maxSalary;
	
	@Column(name="number_of_position")
	private String numberOfPosition;
	
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name="job_title_id")
	private JobTitle jobTitle;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
}
