package com.fernando.log.domain.model.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fernando.log.domain.exception.NegocioException;
import com.fernando.log.domain.model.Entrega;
import com.fernando.log.domain.model.StatusEntrega;
import com.fernando.log.model.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {
	
	private EntregaRepository entregaRepository;
	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public void finalizar(Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		entrega.finalizar();
		
		entregaRepository.save(entrega);
		
	}
	
}
