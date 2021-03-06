package guru.springframevork.msscbrewery.services;

import java.util.UUID;

import guru.springframevork.msscbrewery.web.model.BeerDto;

public interface BeerService {

	BeerDto getBeerById(UUID beerId);
	BeerDto saveNewBeer(BeerDto beerDto);
	void updateBeer(UUID beerId, BeerDto beerDto);
	void deleteById(UUID beerId);

}
