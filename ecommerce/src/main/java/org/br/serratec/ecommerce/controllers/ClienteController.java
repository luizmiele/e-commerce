package org.br.serratec.ecommerce.controllers;

import java.util.List;

import org.br.serratec.ecommerce.dtos.ClienteDTO;
import org.br.serratec.ecommerce.repositories.ClienteRepository;
import org.br.serratec.ecommerce.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@Autowired
	private ClienteRepository clienteRepository;

	@PostMapping
	public ResponseEntity<ClienteDTO> save(@RequestBody ClienteDTO clienteDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteDto);
	}

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.findById(id));
	}

	@PutMapping
	public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO clienteDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.update(clienteDto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
		ClienteDTO cliente = clienteService.findById(id);
		if(cliente != null) {
			clienteService.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body(cliente);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{ ERROR: CLIENTE NÃO ENCONTRADO! }");
	}
}
