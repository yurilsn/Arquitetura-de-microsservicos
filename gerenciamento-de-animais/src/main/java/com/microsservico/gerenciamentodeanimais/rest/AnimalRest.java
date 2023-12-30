package com.microsservico.gerenciamentodeanimais.rest;

import com.microsservico.gerenciamentodeanimais.domain.Animal;
import com.microsservico.gerenciamentodeanimais.repository.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Animal")
@AllArgsConstructor
public class AnimalRest {

    private AnimalRepository animalRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Animal>> findAll() {
        return ResponseEntity.ok().body(animalRepository.findAll());
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Animal>> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(animalRepository.findById(id));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Animal> save(@RequestBody Animal Animal) {
        return ResponseEntity.ok(animalRepository.save(Animal));
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Animal> update(@RequestBody Animal updatedPostGis, @PathVariable("id") Long id) {
        var postGis = animalRepository.findById(id).get();
        BeanUtils.copyProperties(updatedPostGis, postGis);
        return ResponseEntity
                .ok()
                .body(animalRepository.save(postGis));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        animalRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
