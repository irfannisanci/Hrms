package kodlamaio.Hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.JobExperienceService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.Hrms.entities.concretes.JobExperience;
import kodlamaio.Hrms.entities.dtos.JobExperienceDto;

@Service
public class JobExperienceManager implements JobExperienceService{

	private JobExperienceDao jobExperienceDao;
	private ModelMapper modelMapper;
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao,ModelMapper modelMapper) {
		super();
		this.jobExperienceDao = jobExperienceDao;
		this.modelMapper=modelMapper;
	}

	@Override
	public DataResult<List<JobExperienceDto>> getAll() {
		return new SuccessDataResult<List<JobExperienceDto>>(this.jobExperienceDao.findAll().stream().map(element->modelMapper.map(element, JobExperienceDto.class)).collect(Collectors.toList()),"İş deneyimi listelendi");
	}

	@Override
	public Result add(JobExperienceDto jobExperienceDto) {
		JobExperience dto=modelMapper.map(jobExperienceDto, JobExperience.class);
		this.jobExperienceDao.save(dto);
		return new SuccessResult("İş deneyimi eklendi");
	}

}
