package br.com.exemplo.demo.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Schema(name = "Cliente")
public class ClienteWeb{

  @Schema(example = "Maria")
  @NotBlank
  private String nome;
  @Schema(type = "string", pattern = "yyyy-MM-dd", example = "1990-09-10")
  @JsonFormat(pattern = "yyyy-MM-dd")
  @NotNull
  private LocalDate dataDeNascimento;
  @Schema(example = "01001000")
  @NotBlank
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
