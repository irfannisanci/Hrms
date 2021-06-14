package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.JobExperienceDto;

public interface JobExperienceService {
	DataResult<List<JobExperienceDto>> getAll();
	Result add(JobExperienceDto jobExperienceDto);
}
