package com.vinylshop.VinyllShop.controller;

import com.vinylshop.VinyllShop.model.Vinyl;
import com.vinylshop.VinyllShop.service.VinylService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vinyl")
public class VinylResource {
    private final VinylService vinylService;

    public VinylResource(VinylService vinylService) {
        this.vinylService = vinylService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vinyl>> getAllVinyls() {
        List<Vinyl> vinyls = vinylService.findAllVinyls();
        return new ResponseEntity<>(vinyls, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Vinyl> getVinylById(@PathVariable("id") Long id) {
        Vinyl vinyl = vinylService.findVinylById(id);
        return new ResponseEntity<>(vinyl, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Vinyl> addVinyl(@RequestBody Vinyl vinyl) {
        Vinyl newVinyl = vinylService.addVinyl(vinyl);
        return new ResponseEntity<>(newVinyl, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Vinyl> updateVinyl(@RequestBody Vinyl vinyl) {
        Vinyl updatedVinyl = vinylService.updateVinyl(vinyl);
        return new ResponseEntity<>(updatedVinyl, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVinyl(@PathVariable("id") Long id) {
        vinylService.deleteVinyl(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
