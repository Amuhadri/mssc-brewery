package guru.springframevork.msscbrewery.web.controller;

import java.util.UUID;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guru.springframevork.msscbrewery.services.BeerService;
import guru.springframevork.msscbrewery.services.CustomerService;
import guru.springframevork.msscbrewery.web.model.BeerDto;
import guru.springframevork.msscbrewery.web.model.CustomerDto;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	
	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getBeer(@PathVariable UUID customerId){
		
		return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}
	
	
	
	

}
