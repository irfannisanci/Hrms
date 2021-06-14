package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.ResumeService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.ResumeDto;
import kodlamaio.Hrms.entities.dtos.ResumeOutputDto;

@RestController
@RequestMapping("/api/resums")
public class ResumesController {

	private ResumeService resumeService;
	@Autowired
	public ResumesController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ResumeOutputDto>> getAll(){
		return this.resumeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeDto resumeDto) {
		return this.resumeService.add(resumeDto);
	}
	
	@GetMapping("getByCandidateId")
	public DataResult<List<ResumeOutputDto>> findAllByCandidateId(@RequestParam int id){
		return this.resumeService.findAllByCandidateId(id);
	}
}
