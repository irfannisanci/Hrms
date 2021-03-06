package kodlamaio.Hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.GraduateService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.GraduateDao;
import kodlamaio.Hrms.entities.concretes.Graduate;
import kodlamaio.Hrms.entities.dtos.GraduateDto;

@Service
public class GraduateManager implements GraduateService{

	private GraduateDao graduateDao;
	private ModelMapper modelMapper;
	@Autowired
	public GraduateManager(GraduateDao graduateDao,ModelMapper modelMapper) {
		super();
		this.graduateDao = graduateDao;
		this.modelMapper=modelMapper;
	}

	@Override
	public DataResult<List<GraduateDto>> getAll() {
		return new SuccessDataResult<List<GraduateDto>>(this.graduateDao.findAll().stream().map(element->modelMapper.map(element, GraduateDto.class)).collect(Collectors.toList()),"Mezuniyet Bilgisi listelendi");
	}

	@Override
	public Result add(GraduateDto graduateDto) {
		Graduate dto=modelMapper.map(graduateDto, Graduate.class);
		this.graduateDao.save(dto);
		return new SuccessResult("Mezuniyet bilgisi eklendi");
	}

}
