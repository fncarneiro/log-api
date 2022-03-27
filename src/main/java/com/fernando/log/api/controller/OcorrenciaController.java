package com.fernando.log.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.log.api.assembler.OcorrenciaAssembler;
import com.fernando.log.api.model.EntregaModel;
import com.fernando.log.api.model.OcorrenciaModel;
import com.fernando.log.domain.model.Entrega;
import com.fernando.log.domain.model.Ocorrencia;
import com.fernando.log.domain.model.service.BuscaEntregaService;
import com.fernando.log.domain.model.service.RegistroOcorrenciaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
	
	private RegistroOcorrenciaService registroOcorrenciaService;
	private OcorrenciaAssembler ocorrenciaAssembler;
	private BuscaEntregaService buscaEntregaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaModel registrar(@PathVariable Long entregaId,
			@Valid @RequestBody OcorrenciaModel ocorrenciaModel) {
		
		 Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService
				 .registrar(entregaId, ocorrenciaModel.getDescricao());
		 
		 return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
	}
	
	@GetMapping
	public List<OcorrenciaModel> listar(@PathVariable Long entregaId){
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		return ocorrenciaAssembler.toCollectiModel(entrega.getOcorrencias());
	}

}
