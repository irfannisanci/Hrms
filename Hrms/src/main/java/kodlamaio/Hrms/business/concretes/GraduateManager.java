package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.GraduateService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.GraduateDao;
import kodlamaio.Hrms.entities.concretes.Graduate;

@Service
public class GraduateManager implements GraduateService{

	private GraduateDao graduateDao;
	@Autowired
	public GraduateManager(GraduateDao graduateDao) {
		super();
		this.graduateDao = graduateDao;
	}

	@Override
	public DataResult<List<Graduate>> getAll() {
		return new SuccessDataResult<List<Graduate>>(this.graduateDao.findAll());
	}

	@Override
	public Result add(Graduate graduate) {
		this.graduateDao.save(graduate);
		return new SuccessResult("Mezuniyet bilgisi eklendi");
	}

}
