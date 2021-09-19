package com.vinylshop.VinyllShop.repo;

import com.vinylshop.VinyllShop.model.Vinyl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VinylRepo extends JpaRepository<Vinyl, Long> {
    void deleteVinylById(Long id);

    Optional<Vinyl> findVinylById(Long id);
}
