package br.com.exemplo.demo.services;

import br.com.exemplo.demo.entities.Cliente;
import br.com.exemplo.demo.repositories.ClienteRepository;
import java.time.LocalDate;
import java.time.Period;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class CadastroClienteService {

  public static final int IDADE_PERMITIDA = 18;
  private final ClienteRepository clienteRepository;

  public CadastroClienteService(ClienteRepository clienteRepository) {
    this.clienteRepository = clienteRepository;
  }

  public Cliente salvar(@NonNull Cliente cliente) throws RuntimeException {

    if(IDADE_PERMITIDA > getIdade(cliente.getDataDeNascimento()))
      throw new RuntimeException("Obrigatório ser maior de 18 anos para se cadastrar nos sistema!");

    return clienteRepository.salvar(cliente);
  }

  private static int getIdade(LocalDate dataDeNascimento) {
    return Period.between(dataDeNascimento, LocalDate.now()).getYears();
  }
}
