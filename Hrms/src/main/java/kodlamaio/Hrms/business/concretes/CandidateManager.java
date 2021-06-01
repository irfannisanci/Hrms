package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CandidateService;
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
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"İş arayanlar listelendi.");
	}

	@Override
	public Result add(Candidate candidate) {
		if (candidate.getFirstName().isBlank() || candidate.getLastName().isBlank() || candidate.getNationalityId().isBlank() || candidate.getEmail().isBlank() || candidate.getPassword().isBlank()) {
			return new ErrorResult("Tüm alanların doldurulması zorunludur.");
		}else if(!isNationalityIdAlreadyRegistered(candidate)) {
			return new ErrorResult("Bu Tc kimlik numarası ile daha önce kayıt olunmuştur.");
		}else {
		this.candidateDao.save(candidate);
		return new SuccessResult("İş arayan eklendi."); //mernis ve email service eklenecek.
		}
	}
	
	
	public boolean isNationalityIdAlreadyRegistered(Candidate candidate) {
		if (candidateDao.findAllByNationalityId(candidate.getNationalityId()).stream().count()!=0) {
			return false;
		}
		return true;
	}

}
