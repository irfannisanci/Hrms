package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.EducationDto;

public interface EducationService {
	DataResult<List<EducationDto>> getAll();
	Result add(EducationDto educationDto);
}
