package com.example.summerbooking;

import com.example.summerbooking.model.Accommodation;
import com.example.summerbooking.repository.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SummerbookingApplication {

	@Autowired
	private AccommodationRepository accommodationRepository;

	public static void main(String[] args) {
		SpringApplication.run(SummerbookingApplication.class, args);
	}

	@PostConstruct
	public void testData() {

		Accommodation a = new Accommodation();

		a.setName("Apartman More");
		a.setLocation("Pula");
		a.setPricePerNight(120);
		a.setDescription("Prekrasan apartman blizu mora");

		accommodationRepository.save(a);

		System.out.println("TEST DATA SAVED");
	}
}