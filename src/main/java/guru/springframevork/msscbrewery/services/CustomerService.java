package guru.springframevork.msscbrewery.services;

import java.util.UUID;

import guru.springframevork.msscbrewery.web.model.CustomerDto;

public interface CustomerService {
	
	CustomerDto getCustomerById(UUID customeId);

	CustomerDto saveNewCustomer(CustomerDto customerDto);

	void updateCustomer(UUID customerId, CustomerDto customerDto);

	void deleteById(UUID customerId);

	
}
