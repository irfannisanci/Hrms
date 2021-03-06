package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.PersonalService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.PersonalDao;
import kodlamaio.Hrms.entities.concretes.Personal;

@Service
public class PersonalManager implements PersonalService{

	private PersonalDao personalDao;
	
	@Autowired
	public PersonalManager(PersonalDao personalDao) {
		super();
		this.personalDao = personalDao;
	}

	@Override
	public DataResult<List<Personal>> getAll() {
		return new SuccessDataResult<List<Personal>>(this.personalDao.findAll());
	}

	@Override
	public Result add(Personal personal) {
		this.personalDao.save(personal);
		return new SuccessResult("Sistem yöneticisi başarılı şekilde eklendi.");
	}

}
