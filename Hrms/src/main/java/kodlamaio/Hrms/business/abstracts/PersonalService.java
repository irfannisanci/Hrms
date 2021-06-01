package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Personal;

public interface PersonalService {
	DataResult<List<Personal>> getAll();
	Result add(Personal personal);
}
