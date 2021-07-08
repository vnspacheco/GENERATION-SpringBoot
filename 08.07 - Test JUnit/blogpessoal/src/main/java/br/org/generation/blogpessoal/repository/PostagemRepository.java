package br.org.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.blogpessoal.model.PostagemModel;

@Repository
public interface PostagemRepository extends JpaRepository<PostagemModel, Long>{
	
	public List<PostagemModel> findAllByTituloContainingIgnoreCase (String titulo);
	//select * from tb_postagem where titulo like "%titulo%"
}