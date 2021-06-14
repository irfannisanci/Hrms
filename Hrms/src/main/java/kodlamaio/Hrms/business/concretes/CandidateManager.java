package kodlamaio.Hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
import kodlamaio.Hrms.entities.dtos.CandidateInputDto;
import kodlamaio.Hrms.entities.dtos.CandidateOutputDto;

@Service
public class CandidateManager implements CandidateService{
	private CandidateDao candidateDao;
	private UserDao userDao;
	private ModelMapper modelMapper;
	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserDao userDao,ModelMapper modelMapper) {
		super();
		this.candidateDao = candidateDao;
		this.userDao = userDao;
		this.modelMapper=modelMapper;
	}

	@Override
	public DataResult<List<CandidateOutputDto>> getAll() {
		return new SuccessDataResult<List<CandidateOutputDto>>(this.candidateDao.findAll().stream().map(element->modelMapper.map(element, CandidateOutputDto.class)).collect(Collectors.toList()),"İş arayanlar listelendi.");
	}

	@Override
	public Result add(CandidateInputDto candidateInputDto) {
		Candidate candidate=modelMapper.map(candidateInputDto, Candidate.class);
		if (candidate.getFirstName().isBlank() || candidate.getLastName().isBlank() || candidate.getNationalityId().isBlank() || candidate.getEmail().isBlank() || candidate.getPassword().isBlank()) {
			return new ErrorResult("Tüm alanların doldurulması zorunludur.");
		}else if(candidateDao.existsByNationalityId(candidate.getNationalityId())) {
			return new ErrorResult("Bu Tc kimlik numarası ile daha önce kayıt olunmuştur.");
		}else if(userDao.existsByEmail(candidate.getEmail())){
			return new ErrorResult("Bu email daha önce kullanılmıştır.");
		}else {
		this.candidateDao.save(candidate);
		return new SuccessResult("İş arayan eklendi."); //mernis ve email service eklenecek.
		}
	}
	

}
