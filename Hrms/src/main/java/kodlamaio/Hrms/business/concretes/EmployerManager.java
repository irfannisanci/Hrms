package kodlamaio.Hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EmployerCheckService;
import kodlamaio.Hrms.business.abstracts.EmployerService;
import kodlamaio.Hrms.core.dataAccess.UserDao;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.Hrms.entities.concretes.Employer;
import kodlamaio.Hrms.entities.dtos.EmployerInputDto;
import kodlamaio.Hrms.entities.dtos.EmployerOutputDto;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmployerCheckService employerCheckService;
	private UserDao userDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerCheckService employerCheckService,
			UserDao userDao,ModelMapper modelMapper) {
		super();
		this.employerDao = employerDao;
		this.employerCheckService = employerCheckService;
		this.userDao = userDao;
		this.modelMapper=modelMapper;
	}

	@Override
	public DataResult<List<EmployerOutputDto>> getAll() {
		return new SuccessDataResult<List<EmployerOutputDto>>(this.employerDao.findAll().stream().map(element->modelMapper.map(element, EmployerOutputDto.class)).collect(Collectors.toList()),"Data Listelendi");
	}

	@Override
	public Result add(EmployerInputDto employerInputDto) {
		Employer employer=modelMapper.map(employerInputDto, Employer.class);
		if (employer.getCompanyName().isBlank() || employer.getEmail().isBlank() || employer.getPassword().isBlank() || employer.getPhoneNumber().isBlank() || employer.getWebAddress().isBlank()) {
			return new ErrorResult("T??m alanlar??n doldurulmas?? zorunludur.");
		} else if(userDao.existsByEmail(employer.getEmail())){
			return new ErrorResult("Bu email daha ??nce kullan??lm????t??r.");
		}else if(!employerCheckService.CheckEmailAndDomain(employer)) {
			return new ErrorResult("Email ile domain ayn?? olmak zorundad??r.");
		}else {
			this.employerDao.save(employer);
			return new SuccessResult("???? veren eklendi");  //sistem ??al????an?? ve email onay?? eklenecek.
		}
	}

	
}
