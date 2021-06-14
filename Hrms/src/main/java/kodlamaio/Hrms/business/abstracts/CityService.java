package kodlamaio.Hrms.business.abstracts;


import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.CityDto;

public interface CityService {
	DataResult<List<CityDto>> getAll();
	Result add(CityDto cityDto);
}
