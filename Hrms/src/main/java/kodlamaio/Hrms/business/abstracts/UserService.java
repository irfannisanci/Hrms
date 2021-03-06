package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.entities.User;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
public interface UserService {
	DataResult<List<User>> getAll();
	Result add(User user);
}
