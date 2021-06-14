package kodlamaio.Hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.TechnologyService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.TechnologyDao;
import kodlamaio.Hrms.entities.concretes.Technology;
import kodlamaio.Hrms.entities.dtos.TechnologyDto;

@Service
public class TechnologyManager implements TechnologyService{

	private TechnologyDao technologyDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public TechnologyManager(TechnologyDao technologyDao,ModelMapper modelMapper) {
		super();
		this.technologyDao = technologyDao;
		this.modelMapper=modelMapper;
	}

	@Override
	public DataResult<List<TechnologyDto>> getAll() {
		return new SuccessDataResult<List<TechnologyDto>>(this.technologyDao.findAll().stream().map(element->modelMapper.map(element, TechnologyDto.class)).collect(Collectors.toList()),"teknolojiler listelendi");
	}

	@Override
	public Result add(TechnologyDto technologyDto) {
		Technology dto=modelMapper.map(technologyDto, Technology.class);
		this.technologyDao.save(dto);
		return new SuccessResult("Teknoloji deneyimi eklendi.");
	}

}
