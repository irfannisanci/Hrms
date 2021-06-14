package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.JobAdvertService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.JobAdvertDto;
import kodlamaio.Hrms.entities.dtos.JobAdvertGetDto;
import kodlamaio.Hrms.entities.dtos.JobAdvertInputDto;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertsController {
	private JobAdvertService jobAdvertService;
	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertGetDto>> getAll(){
		return this.jobAdvertService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertInputDto jobAdvertInputDto) {
		return this.jobAdvertService.add(jobAdvertInputDto);
	}
	
	@GetMapping("/findByIsActive")
	public DataResult<List<JobAdvertDto>> findByIsActive(){
		return this.jobAdvertService.findByIsActive();
	}
	
	@GetMapping("/findByIsActiveOrderByapplicationDeadline")
	public DataResult<List<JobAdvertDto>> findByIsActiveOrderByCloseDate(){
		return this.jobAdvertService.findByIsActiveOrderByCloseDate();
	}
	
	@GetMapping("/findByIsActiveAndEmployer_CompanyName")
	public DataResult<List<JobAdvertDto>> findByIsActiveAndEmployer_CompanyName(String companyName){
		return this.jobAdvertService.findByIsActiveAndEmployer_CompanyName(companyName);
	}
}
