package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Resume;
import kodlamaio.Hrms.entities.dtos.ResumeDto;

public interface ResumeService {
	DataResult<List<Resume>> getAll();
	Result add(ResumeDto resumeDto);
}
