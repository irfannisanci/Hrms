package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobAdvert;
import kodlamaio.Hrms.entities.dtos.JobAdvertDto;
import kodlamaio.Hrms.entities.dtos.JobAdvertGetDto;
import kodlamaio.Hrms.entities.dtos.JobAdvertInputDto;

public interface JobAdvertService {
	DataResult<List<JobAdvertGetDto>> getAll();
	Result add(JobAdvertInputDto jobAdvertInputDto);
	
	DataResult<JobAdvert> findById(int id);
	DataResult<List<JobAdvertDto>> findByIsActive();
	DataResult<List<JobAdvertDto>> findByIsActiveOrderByCloseDate();
	DataResult<List<JobAdvertDto>> findByIsActiveAndEmployer_CompanyName(String companyName);
	
	DataResult<List<JobAdvertDto>> findByIsActiveTrueAndEmployer_Id(int id);
}
