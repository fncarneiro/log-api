package com.fernando.log.domain.model.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fernando.log.domain.exception.NegocioException;
import com.fernando.log.domain.model.Cliente;
import com.fernando.log.model.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogoClienteService {

	private ClienteRepository clienteRepository;
	
	public Cliente buscar(Long clienteId) {
		return  clienteRepository.findById(clienteId)
				 .orElseThrow(() -> new NegocioException("Cliente não encontrado"));
	}
	
	@Transactional	
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
			.stream()
			.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if(emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com este e-mail");
		}
		
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
}
