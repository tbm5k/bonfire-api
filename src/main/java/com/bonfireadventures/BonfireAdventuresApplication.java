package com.bonfireadventures;

import com.bonfireadventures.entities.City;
import com.bonfireadventures.entities.Continent;
import com.bonfireadventures.entities.Country;
import com.bonfireadventures.entities.Hotel;
import com.bonfireadventures.services.CityService;
import com.bonfireadventures.services.ContinentService;
import com.bonfireadventures.services.CountryService;
import com.bonfireadventures.services.HotelService;
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
	@Autowired
	private CityService cityService;
	@Autowired
	private HotelService hotelService;

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

		City mombasa = new City("Mombasa", kenya);
		City nairobi = new City("Nairobi", kenya);

		cityService.addCity(mombasa);
		cityService.addCity(nairobi);

		Hotel oleSereni = new Hotel("Ole Sereni", nairobi);
		Hotel whitesands = new Hotel("Whitesands", mombasa);

		hotelService.addHotel(whitesands);
		hotelService.addHotel(oleSereni);
	}
}
