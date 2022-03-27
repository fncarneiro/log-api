package com.fernando.log.domain.model.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fernando.log.domain.exception.NegocioException;
import com.fernando.log.domain.model.Entrega;
import com.fernando.log.domain.model.Ocorrencia;
import com.fernando.log.model.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;



@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {
	
	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
	
		return entrega.adicionarOcorrencia(descricao);
	}
} 
