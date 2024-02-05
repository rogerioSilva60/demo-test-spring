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

  public static Builder builder() { return new Builder(); }

  public static final class Builder {
    private String nome;
    private LocalDate dataDeNascimento;
    private String cep;

    private Builder() {}

    public ClienteWeb.Builder nome(String nome) {
      this.nome = nome;
      return this;
    }

    public ClienteWeb.Builder dataDeNascimento(LocalDate dataDeNascimento) {
      this.dataDeNascimento = dataDeNascimento;
      return this;
    }

    public ClienteWeb.Builder cep(String cep) {
      this.cep = cep;
      return this;
    }

    public ClienteWeb build() {
      return new ClienteWeb(this.nome, this.dataDeNascimento, cep);
    }
  }
}
