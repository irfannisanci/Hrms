/*package kodlamaio.Hrms.core.adapters.concretes;

import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlamaio.Hrms.core.adapters.abstracts.MernisCheckService;
import kodlamaio.Hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements MernisCheckService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		
		KPSPublicSoapProxy client=new KPSPublicSoapProxy();
		
		boolean result=true;
		try {
			result=client.TCKimlikNoDogrula(Long.parseLong(candidate.getNationalityId().toUpperCase()), candidate.getFirstName().toUpperCase(new Locale("tr")),
					candidate.getLastName().toUpperCase(new Locale("tr")), candidate.getBirthOfDate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}*/
