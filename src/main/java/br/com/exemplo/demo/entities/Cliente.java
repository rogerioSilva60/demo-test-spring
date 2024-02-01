package br.com.exemplo.demo.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Cliente {
  private Long id;
  private String nome;
  private LocalDate dataDeNascimento;

  public Cliente() {}

  public Cliente(Long id, String nome, LocalDate dataDeNascimento) {
    this.id = id;
    this.nome = nome;
    this.dataDeNascimento = dataDeNascimento;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public LocalDate getDataDeNascimento() {
    return dataDeNascimento;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cliente cliente = (Cliente) o;
    return Objects.equals(id, cliente.id) && Objects.equals(nome, cliente.nome)
        && Objects.equals(dataDeNascimento, cliente.dataDeNascimento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, dataDeNascimento);
  }

  @Override
  public String toString() {
    return "Cliente{ " +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", dataDeNascimento=" + dataDeNascimento +
        " }";
  }

  public static Builder builder() {
    return new Builder();
  }

  public final static class Builder {
    private Long id;
    private String nome;
    private LocalDate dataDeNascimento;

    private Builder() {}

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder nome(String nome) {
      this.nome = nome;
      return this;
    }

    public Builder dataDeNascimento(LocalDate dataDeNascimento) {
      this.dataDeNascimento = dataDeNascimento;
      return this;
    }

    public Cliente build() {
      return new Cliente(this.id, this.nome, this.dataDeNascimento);
    }
  }
}
