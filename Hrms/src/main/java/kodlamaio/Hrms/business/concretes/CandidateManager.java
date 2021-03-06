package kodlamaio.Hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.adapters.VerifyApiService;
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
	private VerifyApiService<Candidate> verifyApiService;
	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserDao userDao,ModelMapper modelMapper,VerifyApiService<Candidate> verifyApiService) {
		super();
		this.candidateDao = candidateDao;
		this.userDao = userDao;
		this.modelMapper=modelMapper;
		this.verifyApiService = verifyApiService;
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
		}else if (!this.verifyApiService.ApiControl(candidate)) {
			return new ErrorResult("Mernis Kimlik Doğrulaması Başarısız Oldu");
		}
		else if(candidateDao.existsByNationalityId(candidate.getNationalityId())) {
			return new ErrorResult("Bu Tc kimlik numarası ile daha önce kayıt olunmuştur.");
		}else if(userDao.existsByEmail(candidate.getEmail())){
			return new ErrorResult("Bu email daha önce kullanılmıştır.");
		}else {
		this.candidateDao.save(candidate);
		return new SuccessResult("İş arayan eklendi."); //email service eklenecek.
		}
	}
	

}
