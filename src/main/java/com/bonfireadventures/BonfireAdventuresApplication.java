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
		Hotel panari = new Hotel("Panari", nairobi);
		Hotel harvest = new Hotel("Harvest", nairobi);
		Hotel kilimanjaro = new Hotel("Kilimanjaro", nairobi);
		Hotel a = new Hotel("A", nairobi);
		Hotel b = new Hotel("B", nairobi);
		Hotel c = new Hotel("C", nairobi);
		Hotel d = new Hotel("D", nairobi);

		Hotel whitesands = new Hotel("Whitesands", mombasa);
		Hotel reef = new Hotel("Reef", mombasa);
		Hotel msaBeech = new Hotel("Mombasa Beech", mombasa);
		Hotel voyager = new Hotel("Voyager", mombasa);
		Hotel e = new Hotel("E", mombasa);
		Hotel f = new Hotel("F", mombasa);
		Hotel g = new Hotel("G", mombasa);
		Hotel h = new Hotel("H", mombasa);

		hotelService.addHotel(whitesands);
		hotelService.addHotel(reef);
		hotelService.addHotel(msaBeech);
		hotelService.addHotel(voyager);
		hotelService.addHotel(e);
		hotelService.addHotel(f);
		hotelService.addHotel(g);
		hotelService.addHotel(h);

		hotelService.addHotel(oleSereni);
		hotelService.addHotel(panari);
		hotelService.addHotel(harvest);
		hotelService.addHotel(kilimanjaro);
		hotelService.addHotel(a);
		hotelService.addHotel(b);
		hotelService.addHotel(c);
		hotelService.addHotel(d);
	}
}
