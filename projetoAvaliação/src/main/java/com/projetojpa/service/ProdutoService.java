package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Produto;
import com.projetojpa.repository.ProdutoRepository;

@Service
public class ProdutoService {
	private final ProdutoRepository produtoRepository;
	
	@Autowired
	   public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
	public List<Produto> buscaTodosProduto() {
        return produtoRepository.findAll();
    }
    public Produto buscaProdutoId(Long id) {
    	Optional<Produto> Produto = produtoRepository.findById(id);
        return Produto.orElse(null);
    }
    public Produto salvaProduto (Produto produto) {
        return produtoRepository.save(produto);
    }
    public Produto alterarProduto (Long id, Produto alterarU) {
		Optional <Produto> existeProduto = produtoRepository.findById(id);
    	if (existeProduto.isPresent()) {
    		alterarU.setId(id);
    		return produtoRepository.save(alterarU);
    	}
    	return null;
    }
    public boolean apagarProduto(Long id) {
    	Optional <Produto> existeProduto = produtoRepository.findById(id);
    	if (existeProduto.isPresent()) {
    		produtoRepository.deleteById(id);
    		return true;
    	}
    	return false;
    }
}