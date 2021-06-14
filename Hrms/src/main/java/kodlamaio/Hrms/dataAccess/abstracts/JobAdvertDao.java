package kodlamaio.Hrms.dataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{
	List<JobAdvert> findByIsActive(boolean status);
	List<JobAdvert> findByIsActiveOrderByCloseDate(boolean status);
	List<JobAdvert> findByIsActiveAndEmployer_CompanyName(boolean status, String companyName);
}
