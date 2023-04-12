package com.ust.ormlearn.Service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ust.ormlearn.Repository.CountryRepository;
import com.ust.ormlearn.model.Country;
@Service
public class CountryService {
	@Autowired
	private CountryRepository countryRepository;
	@Transactional
	public List<Country> getAllCountry() {
		return countryRepository.findAll();
	}
	@Transactional 
	public Country findCountryByCode(String countryCode) {
		Optional<Country> result = countryRepository.findById(countryCode);
		Country country=result.get();
		return country;
	}
	@Transactional 
	public void addCountry(Country country) {
		// TODO Auto-generated method stub
		countryRepository.save(country);
	}
	@Transactional 
	public void updateCountry(String code,String name) {
		// TODO Auto-generated method stub
		Country country = countryRepository.findById(code).orElse(null);
        if (country != null) {
            country.setName(name);
            countryRepository.save(country);
	}
	}
	@Transactional
	public void deleteCountry(String code,String name) {
		countryRepository.deleteById(code);
	}
}
