package com.example.summerbooking.repository;

import com.example.summerbooking.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AccommodationRepository
        extends JpaRepository<Accommodation, Long> {
    List<Accommodation> findByNameContainingIgnoreCase(String name);
    List<Accommodation> findAllByOrderByPricePerNightAsc();

    List<Accommodation> findAllByOrderByPricePerNightDesc();
}
