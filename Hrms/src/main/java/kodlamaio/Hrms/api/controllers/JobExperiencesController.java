package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.JobExperienceService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.JobExperienceDto;

@CrossOrigin
@RestController
@RequestMapping("/api/jobexperiences")
public class JobExperiencesController {

	private JobExperienceService jobExperienceService;
	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobExperienceDto>> getAll(){
		return this.jobExperienceService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobExperienceDto jobExperienceDto) {
		return this.jobExperienceService.add(jobExperienceDto);
	}
}
