package com.microsservico.gerenciamentodepessoas.rest;

import com.microsservico.gerenciamentodepessoas.domain.Pessoa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/Pessoas")
public class PessoaRest {

    @GetMapping
    public List<Pessoa> read(){
        Pessoa p1 = new Pessoa();
        p1.setNome("João");
        p1.setEmail("paulo32@gmail.com");
        p1.setTelefone("3423543534");

        Pessoa p2 = new Pessoa();
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(p1);
        pessoas.add(p2);

        return pessoas;
    }
}
