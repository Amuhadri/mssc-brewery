package guru.springframevork.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframevork.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getCustomerById(UUID customeId) {
		
		return CustomerDto.builder().id(UUID.randomUUID())
				.name("Amir Muhadadri")
				.build();
	}

	@Override
	public CustomerDto saveNewCustomer(CustomerDto customerDto) {
		
		return CustomerDto.builder()
				.id(UUID.randomUUID())
				.build();
	}
	
	@Override
	public void updateCustomer(UUID customerId, CustomerDto customerDto) {
		
	}

	@Override
	public void deleteById(UUID customerId) {
		log.debug("Deleting a customer...");
		
	}





}
