package com.bonfireadventures;

import com.bonfireadventures.entities.Continent;
import com.bonfireadventures.entities.Country;
import com.bonfireadventures.services.ContinentService;
import com.bonfireadventures.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BonfireAdventuresApplication implements CommandLineRunner {
	@Autowired
	private ContinentService continentService;
	@Autowired
	private CountryService countryService;

	public static void main(String[] args) {
		SpringApplication.run(BonfireAdventuresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Continent africa = new Continent("Africa");
		Continent europe = new Continent("Europe");
		Continent asia = new Continent("Asia");
		Continent oceania = new Continent("Oceania");
		Continent northAmerica = new Continent("North-America");
		Continent southAmerica = new Continent("South-America");
		Continent antarctica = new Continent("Antarctica");

		continentService.addContinent(africa);
		continentService.addContinent(europe);
		continentService.addContinent(asia);
		continentService.addContinent(oceania);
		continentService.addContinent(northAmerica);
		continentService.addContinent(southAmerica);
		continentService.addContinent(antarctica);

		Country kenya = new Country("Kenya", africa);
		Country tanzania = new Country("Tanzania", africa);

		countryService.addCountry(kenya);
		countryService.addCountry(tanzania);
	}
}
