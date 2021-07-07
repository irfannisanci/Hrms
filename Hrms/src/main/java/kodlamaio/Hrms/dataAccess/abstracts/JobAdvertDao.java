package kodlamaio.Hrms.dataAccess.abstracts;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{
	JobAdvert findById(int id);
	List<JobAdvert> findByIdAndIsActive(int id, boolean status);
	List<JobAdvert> findByIsActive(boolean status);
	List<JobAdvert> findByIsActiveOrderByCloseDate(boolean status);
	List<JobAdvert> findByIsActiveAndEmployer_CompanyName(boolean status, String companyName);
	List<JobAdvert> findByIsActiveTrueAndEmployer_Id(int id);
}
