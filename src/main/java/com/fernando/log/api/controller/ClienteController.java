package com.fernando.log.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.log.domain.model.Cliente;
import com.fernando.log.domain.model.service.CatalogoClienteService;
import com.fernando.log.model.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {	
	private CatalogoClienteService catalogoClienteService;
	
	private ClienteRepository ClienteRepository;	
	
	@GetMapping
	public List<Cliente> listar() {
		return ClienteRepository.findAll();		
	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable  Long clienteId) {
		return ClienteRepository.findById(clienteId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
		
//		Optional<Cliente> cliente = ClienteRepositpry.findById(clienteId);
//		if (cliente.isPresent()) {
//			return ResponseEntity.ok(cliente.get());
//		}
//		return ResponseEntity.notFound().build();
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		
//		return ClienteRepository.save(cliente);
		return catalogoClienteService.salvar(cliente);
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> alterar(@PathVariable  Long clienteId, @Valid @RequestBody Cliente cliente) {
		if(!ClienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(clienteId);
//		cliente = ClienteRepository.save(cliente);
		cliente = catalogoClienteService.salvar(cliente);
		
		return ResponseEntity.ok(cliente);		
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable  Long clienteId) {
		if(!ClienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}		
//		ClienteRepository.deleteById(clienteId);
		catalogoClienteService.excluir(clienteId);
		
		return ResponseEntity.noContent().build(); 		
	}
}
