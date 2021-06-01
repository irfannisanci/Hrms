package kodlamaio.Hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EmployerCheckService;
import kodlamaio.Hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.Hrms.entities.concretes.Employer;

@Service
public class EmployerCheckManager implements EmployerCheckService{

	private EmployerDao employerDao;
	
	public EmployerCheckManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

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

	@Override
	public boolean isEmailAlreadyRegistered(Employer employer) {
		if (employerDao.findAllByEmail(employer.getEmail()).stream().count()!=0) {
			return false;
		}
		return true;
	}

}
