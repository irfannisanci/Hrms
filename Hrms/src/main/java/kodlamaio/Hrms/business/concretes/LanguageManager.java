package kodlamaio.Hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.LanguageService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.Hrms.entities.concretes.Language;
import kodlamaio.Hrms.entities.dtos.LanguageDto;

@Service
public class LanguageManager implements LanguageService{
	
	private LanguageDao languageDao;
	private ModelMapper modelMapper;
	@Autowired
	public LanguageManager(LanguageDao languageDao,ModelMapper modelMapper) {
		super();
		this.languageDao = languageDao;
		this.modelMapper=modelMapper;
	}

	@Override
	public DataResult<List<LanguageDto>> getAll() {
		return new SuccessDataResult<List<LanguageDto>>(this.languageDao.findAll().stream().map(element->modelMapper.map(element, LanguageDto.class)).collect(Collectors.toList()));
	}

	@Override
	public Result add(LanguageDto languageDto) {
		Language dto=modelMapper.map(languageDto, Language.class);
		this.languageDao.save(dto);
		return new SuccessResult("Dil eklendi");
	}

}
