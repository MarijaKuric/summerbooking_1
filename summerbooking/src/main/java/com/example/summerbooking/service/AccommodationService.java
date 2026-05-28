package com.example.summerbooking.service;

import com.example.summerbooking.model.Accommodation;
import com.example.summerbooking.repository.AccommodationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;

    public AccommodationService(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    public List<Accommodation> getAll() {
        return accommodationRepository.findAll();
    }

    public Accommodation save(Accommodation accommodation) {
        return accommodationRepository.save(accommodation);
    }

    public Optional<Accommodation> getById(Long id) {
        return accommodationRepository.findById(id);
    }

    public void delete(Long id) {
        accommodationRepository.deleteById(id);
    }
    public List<Accommodation> search(String keyword) {

        return accommodationRepository
                .findByNameContainingIgnoreCase(keyword);
    }
    public List<Accommodation> sortByPriceAsc() {

        return accommodationRepository
                .findAllByOrderByPricePerNightAsc();
    }

    public List<Accommodation> sortByPriceDesc() {

        return accommodationRepository
                .findAllByOrderByPricePerNightDesc();
    }
}