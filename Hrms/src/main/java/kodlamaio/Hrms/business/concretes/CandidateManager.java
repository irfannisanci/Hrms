package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CandidateService;
import kodlamaio.Hrms.core.dataAccess.UserDao;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.Hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{
	private CandidateDao candidateDao;
	private UserDao userDao;
	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserDao userDao) {
		super();
		this.candidateDao = candidateDao;
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"İş arayanlar listelendi.");
	}

	@Override
	public Result add(Candidate candidate) {
		if (candidate.getFirstName().isBlank() || candidate.getLastName().isBlank() || candidate.getNationalityId().isBlank() || candidate.getEmail().isBlank() || candidate.getPassword().isBlank()) {
			return new ErrorResult("Tüm alanların doldurulması zorunludur.");
		}else if(candidateDao.existsByNationalityId(candidate.getNationalityId())) {
			return new ErrorResult("Bu Tc kimlik numarası ile daha önce kayıt olunmuştur.");
		}else if(!userDao.existsByEmail(candidate.getEmail())){
			return new ErrorResult("Bu email daha önce kullanılmıştır.");
		}else {
		this.candidateDao.save(candidate);
		return new SuccessResult("İş arayan eklendi."); //mernis ve email service eklenecek.
		}
	}
	

}
