package kodlamaio.Hrms.adapters;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import kodlamaio.Hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisAdapter implements VerifyApiService<Candidate> {

	@Override
	public boolean ApiControl(Candidate candidate) {
		KPSPublicSoapProxy kpsPublic;
		try {
			kpsPublic = new KPSPublicSoapProxy();
			boolean durum = kpsPublic.TCKimlikNoDogrula(
					Long.parseLong(candidate.getNationalityId()), 
							candidate.getFirstName().toUpperCase(), 
							candidate.getLastName().toUpperCase(), 
							Integer.parseInt(candidate.getBirthOfDate()));
			return durum;
		} catch (RemoteException | NumberFormatException e1) {
			e1.printStackTrace();
		}
			return false;
	}

}
