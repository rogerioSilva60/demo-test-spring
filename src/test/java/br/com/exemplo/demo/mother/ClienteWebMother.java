package br.com.exemplo.demo.mother;

import br.com.exemplo.demo.dtos.ClienteWeb;
import java.time.LocalDate;

public class ClienteWebMother {

  private ClienteWebMother() {}

  public static ClienteWeb.Builder clienteWebNovoMaiorDeIdade() {
    return ClienteWeb.builder()
        .nome("Maria")
        .dataDeNascimento(LocalDate.of(1990, 9, 10))
        .cep("01001000");
  }

  public static ClienteWeb.Builder clienteWebNovoMenorDeIdade() {
    return clienteWebNovoMaiorDeIdade()
        .dataDeNascimento(LocalDate.now().minusYears(17));
  }

}
