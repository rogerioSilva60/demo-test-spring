package br.com.exemplo.demo.repositories;

import br.com.exemplo.demo.entities.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteRepository {

  public Cliente salvar(Cliente cliente) {
    return cliente;
  }

}
