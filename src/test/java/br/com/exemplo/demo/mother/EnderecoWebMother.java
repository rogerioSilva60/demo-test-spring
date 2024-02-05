package br.com.exemplo.demo.mother;

import br.com.exemplo.demo.dtos.EnderecoWeb;
import br.com.exemplo.demo.dtos.EnderecoWebXml;

public class EnderecoWebMother {

  private EnderecoWebMother() {}

  public static EnderecoWebXml.Builder enderecoWebXmlNovo() {
    return EnderecoWebXml.builder()
        .cep("01001-000")
        .logradouro("Praça da Sé")
        .complemento("lado ímpar")
        .bairro("Sé")
        .localidade("São Paulo")
        .uf("SP")
        .ibge("3550308")
        .gia("1004")
        .ddd("11")
        .siafi("7107");
  }

  public static EnderecoWeb.Builder enderecoWebJsonNovo() {
    return EnderecoWeb.builder()
        .cep("01001-000")
        .logradouro("Praça da Sé")
        .complemento("lado ímpar")
        .bairro("Sé")
        .localidade("São Paulo")
        .uf("SP");
  }

}
