package kodlamaio.Hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="resume_job_exp")
@Entity
public class JobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="started_date")
	private Date startedDate;
	
	@Column(name="ended_date")
	private Date endedDate;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Resume.class)
	@JoinColumn(name="resume_id",referencedColumnName = "id")
	private Resume resume;
	
	@ManyToOne(targetEntity = JobTitle.class)
	@JoinColumn(name="job_title_id",referencedColumnName = "id")
	private JobTitle jobTitle;
}
