package com.zertificon.solution;

import com.zertificon.solution.model.Address;
import com.zertificon.solution.model.User;
import com.zertificon.solution.repository.AddressRepository;
import com.zertificon.solution.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback
@Transactional
public class UserAddressApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Test
	public void persistUserTest() {
		User user = new User();
		user.setFirstName("Hamidreza");
		user.setLastName("Bidgoli");
		user.setAddresses(getAddresses());
		userRepository.save(user);
		Assert.assertNotNull("The User must has an ID after persisting", user.getId());
	}

	private Set<Address> getAddresses() {
		HashSet<Address> addresses = new HashSet<>();
		Address address = getAddress();
		addresses.add(address);
		return addresses;
	}

	private Address getAddress() {
		Address address = new Address();
		address.setEmail("Hamidreza.bidgoli@gmail.com");
		address.setLocation("Tehran, Iran");
		address.setPhoneNo("00491778277296");
		address.setPostalCode("009821");
		addressRepository.save(address);
		return address;
	}

	@Test
	public void contextLoads() {
	}

}
