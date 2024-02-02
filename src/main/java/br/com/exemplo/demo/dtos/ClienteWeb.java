package br.com.exemplo.demo.dtos;

import java.time.LocalDate;

public class ClienteWeb{

  private String nome;
  private LocalDate dataDeNascimento;
  private String cep;

  public ClienteWeb() {}

  public ClienteWeb(String nome, LocalDate dataDeNascimento, String cep) {
    this.nome = nome;
    this.dataDeNascimento = dataDeNascimento;
    this.cep = cep;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public LocalDate getDataDeNascimento() {
    return dataDeNascimento;
  }

  public void setDataDeNascimento(LocalDate dataDeNascimento) {
    this.dataDeNascimento = dataDeNascimento;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }
}
