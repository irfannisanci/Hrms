package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EmployerCheckService;
import kodlamaio.Hrms.business.abstracts.EmployerService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.Hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmployerCheckService employerCheckService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,EmployerCheckService employerCheckService) {
		super();
		this.employerDao = employerDao;
		this.employerCheckService=employerCheckService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(Employer employer) {
		if (employer.getCompanyName().isBlank() || employer.getEmail().isBlank() || employer.getPassword().isBlank() || employer.getPhoneNumber().isBlank() || employer.getWebAddress().isBlank()) {
			return new ErrorResult("Tüm alanların doldurulması zorunludur.");
		} else if(!employerCheckService.isEmailAlreadyRegistered(employer)){
			return new ErrorResult("Bu email daha önce kullanılmıştır.");
		}else if(!employerCheckService.CheckEmailAndDomain(employer)) {
			return new ErrorResult("Email ile domain aynı olmak zorundadır.");
		}else {
			this.employerDao.save(employer);
			return new SuccessResult("İş veren eklendi");  //sistem çalışanı ve email onayı eklenecek.
		}
	}
	
}
