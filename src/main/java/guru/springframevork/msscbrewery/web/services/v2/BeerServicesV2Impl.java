package guru.springframevork.msscbrewery.web.services.v2;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframevork.msscbrewery.web.model.v2.BeerDtoV2;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BeerServicesV2Impl implements BeerServiceV2 {

	@Override
	public BeerDtoV2 getBeerById(UUID beerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(UUID beerId) {
		// TODO Auto-generated method stub
		
	}

}
