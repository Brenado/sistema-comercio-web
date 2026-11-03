package br.com.fatec.sistemacomercioweb.service;

import br.com.fatec.sistemacomercioweb.model.Produto;
import br.com.fatec.sistemacomercioweb.repository.ClienteRepository;
import br.com.fatec.sistemacomercioweb.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listar() {
        return repository.findAllByOrderByIdAsc();
    }

    public Produto cadastrar(Produto produto) { return repository.save(produto); }
}
