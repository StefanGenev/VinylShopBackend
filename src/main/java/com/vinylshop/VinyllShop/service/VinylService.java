package com.vinylshop.VinyllShop.service;

import com.vinylshop.VinyllShop.exceptions.VinylNotFoundException;
import com.vinylshop.VinyllShop.model.Vinyl;
import com.vinylshop.VinyllShop.repo.VinylRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VinylService {
    private final VinylRepo vinylRepo;

    public VinylService(VinylRepo vinylRepo) {
        this.vinylRepo = vinylRepo;
    }

    public Vinyl addVinyl(Vinyl vinyl){
        return vinylRepo.save(vinyl);
    }

    public List<Vinyl> findAllVinyls(){
        return vinylRepo.findAll();
    }

    public Vinyl updateVinyl(Vinyl vinyl){
        return vinylRepo.save(vinyl);
    }

    public Vinyl findVinylById(Long id){
        return vinylRepo.findVinylById(id)
                .orElseThrow(() -> new VinylNotFoundException("vinyl with id " + id + "was not found!"));
    }

    @Transactional
    public void deleteVinyl(Long id){
        vinylRepo.deleteVinylById(id);
    }
}
