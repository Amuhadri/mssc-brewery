package guru.springframevork.msscbrewery.web.controller.v2;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframevork.msscbrewery.web.model.v2.BeerDtoV2;
import guru.springframevork.msscbrewery.web.services.v2.BeerServiceV2;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

	@Autowired
	BeerServiceV2 beerServiceV2;
	
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDtoV2> getBeer(@PathVariable UUID beerId){
		
		return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BeerDtoV2> handlePost(@RequestBody BeerDtoV2 beerDto) {
		
		BeerDtoV2 saveDto = beerServiceV2.saveNewBeer(beerDto);
		
		HttpHeaders headers = new HttpHeaders();
		
		String hostNameUrl = "http://localhost:8080";
		headers.add("Location", hostNameUrl + "/api/v1/beer/" + saveDto.getId().toString());
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping({"/{beerId}"})
	public ResponseEntity<BeerDtoV2> handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beerDto){
		
		beerServiceV2.updateBeer(beerId, beerDto);
		return new ResponseEntity<> (HttpStatus.NO_CONTENT);
		
	}
	
	@DeleteMapping({"/{beerId}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable("beerId") UUID beerId) {
		beerServiceV2.deleteById(beerId);
	} 

}
