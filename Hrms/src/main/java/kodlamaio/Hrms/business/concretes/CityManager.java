package kodlamaio.Hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CityService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CityDao;
import kodlamaio.Hrms.entities.concretes.City;
import kodlamaio.Hrms.entities.dtos.CityDto;

@Service
public class CityManager implements CityService{

	private CityDao cityDao;
	private ModelMapper modelMapper;
	@Autowired
	public CityManager(CityDao cityDao,ModelMapper modelMapper) {
		super();
		this.cityDao = cityDao;
		this.modelMapper=modelMapper;
	}

	@Override
	public DataResult<List<CityDto>> getAll() {
		return new SuccessDataResult<List<CityDto>>(this.cityDao.findAll().stream().map(element->modelMapper.map(element, CityDto.class)).collect(Collectors.toList()));
	}

	@Override
	public Result add(CityDto cityDto) {
		City dto=modelMapper.map(cityDto, City.class);
		this.cityDao.save(dto);
		return new SuccessResult("Şehir eklendi.");
	}

}
