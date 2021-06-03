package kodlamaio.Hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EmployerCheckService;
import kodlamaio.Hrms.entities.concretes.Employer;

@Service
public class EmployerCheckManager implements EmployerCheckService{

	
	@Override
	public boolean CheckEmailAndDomain(Employer employer) {
		String[] employerWebAddress=employer.getWebAddress().split("www.",2);
		String webAddress=employerWebAddress[1];
		
		String[] employerEmail=employer.getEmail().split("@");
		String employerDomain=employerEmail[1];
		
		if (employerDomain.equals(webAddress)) {
			return true;
		}
		return false;
	}


}
