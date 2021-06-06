package kodlamaio.Hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.JobAdvertService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.Hrms.entities.concretes.JobAdvert;
import kodlamaio.Hrms.entities.dtos.JobAdvertDto;

@Service
public class JobAdvertManager implements JobAdvertService{
	private JobAdvertDao jobAdvertDao;
	private ModelMapper modelMapper;
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao,ModelMapper modelMapper) {
		super();
		this.jobAdvertDao=jobAdvertDao;
		this.modelMapper=modelMapper;
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
	}
	
	@Override
	public Result add(JobAdvert jobAdver) {
		this.jobAdvertDao.save(jobAdver);
		return new SuccessResult("İş ilanı açıldı");
	}


	@Override
	public DataResult<List<JobAdvertDto>> findByIsActive() {
		return new SuccessDataResult<List<JobAdvertDto>>(this.jobAdvertDao.findByIsActive(true).stream().map(element->modelMapper.map(element, JobAdvertDto.class)).collect(Collectors.toList()),"Aktif iş ilanları listelendi");
	}

	@Override
	public DataResult<List<JobAdvertDto>> findByIsActiveOrderByApplicationDeadline() {
		return new SuccessDataResult<List<JobAdvertDto>>(this.jobAdvertDao.findByIsActiveOrderByApplicationDeadline(true).stream().map(element->modelMapper.map(element, JobAdvertDto.class)).collect(Collectors.toList()),"Aktif iş ilanları tarihe göre sıralandı.");
	}

	@Override
	public DataResult<List<JobAdvertDto>> findByIsActiveAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertDto>>(this.jobAdvertDao.findByIsActiveAndEmployer_CompanyName(true,companyName).stream().map(element->modelMapper.map(element, JobAdvertDto.class)).collect(Collectors.toList()));
	}

	
}
