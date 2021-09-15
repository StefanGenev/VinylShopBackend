package com.vinylshop.VinyllShop.repo;

import com.vinylshop.VinyllShop.model.Vinyl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface VinylRepo extends JpaRepository<Vinyl, Long> {
    void deleteVinylById(Long id);

    Optional<Vinyl> findVinylById(Long id);
}
