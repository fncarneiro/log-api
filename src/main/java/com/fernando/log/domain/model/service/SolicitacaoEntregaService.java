package com.fernando.log.domain.model.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fernando.log.domain.model.Cliente;
import com.fernando.log.domain.model.Entrega;
import com.fernando.log.domain.model.StatusEntrega;
import com.fernando.log.model.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

	 private EntregaRepository entregaRepository;
	 private CatalogoClienteService catalogoClienteService;
	 
	 @Transactional
	 public Entrega solicitar(Entrega entrega) {
		 
		Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());
		 
		 entrega.setCliente(cliente);		 
		 entrega.setStatus(StatusEntrega.PENDENTE);
		 entrega.setDataPedido(OffsetDateTime.now());	 
		 
		 return entregaRepository.save(entrega);
	 }
	
}
