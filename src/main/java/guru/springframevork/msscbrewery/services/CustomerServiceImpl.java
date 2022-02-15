package guru.springframevork.msscbrewery.services;

import java.util.UUID;
import org.springframework.stereotype.Service;
import guru.springframevork.msscbrewery.web.model.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getCustomerById(UUID customeId) {
		
		return CustomerDto.builder().id(UUID.randomUUID())
				.name("Amir Muhadadri")
				.build();
	}

}
