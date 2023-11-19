package com.Restaurante.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Restaurante.api.atendimento.Pedido;
import com.Restaurante.api.repository.PedidoRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired 
	private PedidoRepository pedidoRepository;
	@GetMapping 
	public List <Pedido> listar(){
		return pedidoRepository.findAll();
		}
	
	
	@PostMapping 
	public Pedido adicionar (@RequestBody Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@DeleteMapping 
	public void  deletar (@RequestBody Pedido pedido) {
		pedidoRepository.delete(pedido);
	}
	
	@PutMapping 
	public Pedido Atualizar (@RequestBody Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	 @Transactional
	    public void salvarPedido(Pedido pedido) {
	        try {
	            pedidoRepository.save(pedido);
	        } catch (Exception ex) {
	         
	            ex.printStackTrace();
	            throw new RuntimeException("Ocorreu um erro ao salvar o pedido.");
	        }
	    }

}
