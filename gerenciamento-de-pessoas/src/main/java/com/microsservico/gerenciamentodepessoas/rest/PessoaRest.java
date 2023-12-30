package com.microsservico.gerenciamentodepessoas.rest;

import com.microsservico.gerenciamentodepessoas.domain.Pessoa;
import com.microsservico.gerenciamentodepessoas.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Pessoas")
@AllArgsConstructor
public class PessoaRest {

    private PessoaRepository pessoaRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Pessoa>> findAll() {
        return ResponseEntity.ok().body(pessoaRepository.findAll());
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Pessoa>> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(pessoaRepository.findById(id));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(pessoaRepository.save(pessoa));
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Pessoa> update(@RequestBody Pessoa updatedPessoa, @PathVariable("id") Long id) {
        var pessoa = pessoaRepository.findById(id).get();
        BeanUtils.copyProperties(updatedPessoa, pessoa);
        return ResponseEntity
                .ok()
                .body(pessoaRepository.save(pessoa));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        pessoaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
}
