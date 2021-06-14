package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.GraduateDto;

public interface GraduateService {
	DataResult<List<GraduateDto>> getAll();
	Result add(GraduateDto graduateDto);
}
