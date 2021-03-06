package kodlamaio.Hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EducationService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.Hrms.entities.concretes.Education;
import kodlamaio.Hrms.entities.dtos.EducationDto;

@Service
public class EducationManager implements EducationService{

	private EducationDao educationDao;
	private ModelMapper modelMapper;
	@Autowired
	public EducationManager(EducationDao educationDao,ModelMapper modelMapper) {
		super();
		this.educationDao = educationDao;
		this.modelMapper=modelMapper;
	}

	@Override
	public DataResult<List<EducationDto>> getAll() {
		return new SuccessDataResult<List<EducationDto>>(this.educationDao.findAll().stream().map(element->modelMapper.map(element, EducationDto.class)).collect(Collectors.toList()),"Eğitim bilgisi listelendi");
	}

	@Override
	public Result add(EducationDto educationDto) {
		Education dto=modelMapper.map(educationDto, Education.class);
		this.educationDao.save(dto);
		return new SuccessResult("Eğitim bilgisi eklendi");
	}

}
