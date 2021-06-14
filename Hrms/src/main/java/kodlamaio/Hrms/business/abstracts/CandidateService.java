package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.CandidateInputDto;
import kodlamaio.Hrms.entities.dtos.CandidateOutputDto;

public interface CandidateService {
	DataResult<List<CandidateOutputDto>> getAll();
	Result add(CandidateInputDto candidateInputDto);
}
