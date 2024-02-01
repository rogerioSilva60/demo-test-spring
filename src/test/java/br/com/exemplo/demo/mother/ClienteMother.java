package br.com.exemplo.demo.mother;

import br.com.exemplo.demo.entities.Cliente;
import java.time.LocalDate;

public class ClienteMother {

  private ClienteMother() {}

  public static Cliente.Builder clienteNovoMaiorDeIdade() {
    return Cliente.builder()
        .nome("Maria")
        .dataDeNascimento(LocalDate.of(1990, 9, 10));
  }

  public static Cliente.Builder clienteNovoMenorDeIdade() {
    return Cliente.builder().dataDeNascimento(LocalDate.now().minusYears(17));
  }

  public static Cliente.Builder clienteExistente() {
    return clienteNovoMaiorDeIdade().id(1L);
  }

  public static Cliente.Builder clienteComIdInexistente() {
    return clienteNovoMaiorDeIdade().id(99L);
  }
}
