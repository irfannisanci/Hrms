package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {
	DataResult<List<JobAdvert>> getAll();
	Result add(JobAdvert jobAdvert);
}
