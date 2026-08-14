package com.biolab.loja.repositories;

import com.biolab.loja.entities.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//annotation para definir reposiory e herança para inversão de dependencias
@Repository
public interface ProdutoRepository extends JpaRepository<Produtos,Long> {
}
