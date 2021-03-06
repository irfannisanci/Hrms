package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.ResumeDto;
import kodlamaio.Hrms.entities.dtos.ResumeOutputDto;

public interface ResumeService {
	DataResult<List<ResumeOutputDto>> getAll();
	Result add(ResumeDto resumeDto);
	DataResult<List<ResumeOutputDto>> findAllByCandidateId(int id);
}
