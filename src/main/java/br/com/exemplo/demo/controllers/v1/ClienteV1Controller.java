package br.com.exemplo.demo.controllers.v1;

import br.com.exemplo.demo.dtos.ClienteWeb;
import br.com.exemplo.demo.entities.Cliente;
import br.com.exemplo.demo.services.CadastroClienteService;
import jakarta.validation.Valid;
import java.net.URI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RequestMapping("/api/v1/clientes")
@RestController
public class ClienteV1Controller {
  public static final String ID = "/{id}";
  public final CadastroClienteService cadastroClienteService;

  public ClienteV1Controller(CadastroClienteService cadastroClienteService) {
    this.cadastroClienteService = cadastroClienteService;
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  ResponseEntity<Void> salvar(@Valid @RequestBody ClienteWeb clienteWeb){
    Cliente clienteSalvo = cadastroClienteService.salvar(clienteWeb);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(ID)
        .buildAndExpand(clienteSalvo.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

}
