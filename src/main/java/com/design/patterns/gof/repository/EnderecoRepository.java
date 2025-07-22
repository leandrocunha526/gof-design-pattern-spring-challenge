package com.design.patterns.gof.repository;

import com.design.patterns.gof.model.Endereco;
import org.springframework.data.repository.CrudRepository;

public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
