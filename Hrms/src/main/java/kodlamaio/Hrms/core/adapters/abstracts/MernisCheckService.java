package kodlamaio.Hrms.core.adapters.abstracts;

import kodlamaio.Hrms.entities.concretes.Candidate;

public interface MernisCheckService {
	public boolean checkIfRealPerson(Candidate candidate);
}
