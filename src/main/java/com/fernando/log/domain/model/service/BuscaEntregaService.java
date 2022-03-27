package com.fernando.log.domain.model.service;

import org.springframework.stereotype.Service;

import com.fernando.log.domain.exception.EntidadeNaoEncontradaException;
import com.fernando.log.domain.model.Entrega;
import com.fernando.log.model.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {
	
	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}

}
