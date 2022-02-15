package guru.springframevork.msscbrewery.web.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframevork.msscbrewery.services.CustomerService;
import guru.springframevork.msscbrewery.web.model.CustomerDto;

@Deprecated
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	
	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId){
		
		return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<CustomerDto> handlePost(@RequestBody CustomerDto customerDto){
		
		CustomerDto saveDto = customerService.saveNewCustomer(customerDto);
		
		HttpHeaders headers = new HttpHeaders();
		
		String hostNameUrl = "http://localhost:8080";
		headers.add("Location", hostNameUrl + "/api/v1/customer/" + saveDto.getId().toString());
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping({"/{customerId}"})
	public ResponseEntity<CustomerDto> handlePut(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto){
		
		customerService.updateCustomer(customerId, customerDto);
		
		return new ResponseEntity<> (HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable("customerId") UUID customerId) {
		customerService.deleteById(customerId);
	}
	
	
	
	

}
