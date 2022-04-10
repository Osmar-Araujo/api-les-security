package com.les.apiv2.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.les.apiv2.entities.Cartao;
import com.les.apiv2.service.CartaoService;

@CrossOrigin
@RestController
@RequestMapping("/api/cards")
public class CartaoController {
	
	@Autowired
	private CartaoService cartaoService;
	
	@GetMapping
	public ResponseEntity<List<Cartao>> findAll(){
		List<Cartao> list = cartaoService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping(value = "/cadastrar")
	public ResponseEntity<Cartao> save(@RequestBody Cartao cartao){
		return new ResponseEntity<Cartao>(this.cartaoService.save(cartao),HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{idUsuario}")
	public ResponseEntity<List<Cartao>> findAllByIdUsuario(@PathVariable("idUsuario") Integer idUsuario){
		List<Cartao> list = cartaoService.findAllByIdUsuario(idUsuario);
		return ResponseEntity.ok(list);
	}

}

