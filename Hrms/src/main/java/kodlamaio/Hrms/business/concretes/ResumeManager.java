package kodlamaio.Hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.ResumeService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.Hrms.entities.concretes.Resume;
import kodlamaio.Hrms.entities.dtos.ResumeDto;
import kodlamaio.Hrms.entities.dtos.ResumeOutputDto;

@Service
public class ResumeManager implements ResumeService{

	private ResumeDao resumeDao;
	private ModelMapper modelMapper;
	@Autowired
	public ResumeManager(ResumeDao resumeDao,ModelMapper modelMapper) {
		super();
		this.resumeDao = resumeDao;
		this.modelMapper=modelMapper;
	}

	@Override
	public DataResult<List<ResumeOutputDto>> getAll() {
		return new SuccessDataResult<List<ResumeOutputDto>>(this.resumeDao.findAll().stream().map(element->modelMapper.map(element, ResumeOutputDto.class)).collect(Collectors.toList()));
	}

	@Override
	public Result add(ResumeDto resumeDto) {
		Resume resume=modelMapper.map(resumeDto, Resume.class);
		this.resumeDao.save(resume);
		return new SuccessResult("Cv Eklendi");
	}

	@Override
	public DataResult<List<ResumeOutputDto>> findAllByCandidateId(int id) {
		return new SuccessDataResult<List<ResumeOutputDto>>(this.resumeDao.findAllByCandidateId(id).stream().map(element->modelMapper.map(element, ResumeOutputDto.class)).collect(Collectors.toList()));
	}

}
