package kodlamaio.Hrms.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.PersonalService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Personal;

@RestController
@RequestMapping("api/personals")
public class PersonalsController {
	
	private PersonalService personalService;
	@Autowired
	public PersonalsController(PersonalService personalService) {
		super();
		this.personalService = personalService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Personal>> getAll(){
		return this.personalService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Personal personal) {
		return this.personalService.add(personal);
	}
}
