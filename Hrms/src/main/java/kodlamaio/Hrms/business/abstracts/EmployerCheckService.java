package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.entities.concretes.Employer;

public interface EmployerCheckService {
	boolean CheckEmailAndDomain(Employer employer);
	boolean isEmailAlreadyRegistered(Employer employer);
}
