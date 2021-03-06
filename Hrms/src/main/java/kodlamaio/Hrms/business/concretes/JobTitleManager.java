package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.JobTitleService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.Hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{

	private JobTitleDao jobTitleDao;
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll());
	}

	@Override
	public Result add(JobTitle jobTitle) {
		if(jobTitleDao.findAllByTitleName(jobTitle.getTitleName()).stream().count() !=0 ) {
			return new ErrorDataResult<JobTitle>(null,"Böyle Bir İş Başlığı Mevcut");
			
		}
		return new SuccessDataResult<JobTitle>(this.jobTitleDao.save(jobTitle),"İş Başlığı Eklendi");
	}

}
