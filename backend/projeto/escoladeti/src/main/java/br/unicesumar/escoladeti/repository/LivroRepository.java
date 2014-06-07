package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long>{
    
    public Livro findById(Long id);
    
    public Livro findByNomeAndAutorAndEditoraAndAnoEdicao(
            String nome, String autor, String editora, Long anoEdicao);
    
    public Page<Livro> findByNomeContainingOrderByNomeAsc(String nome, Pageable pageable);
    
}
