package br.com.exemplo.demo.entities;

import java.util.Objects;

public class Endereco {

  private String cep;
  private String logradouro;
  private String complemento;
  private String bairro;
  private String localidade;
  private String uf;

  public Endereco() {}

  public Endereco(String cep, String logradouro, String complemento, String bairro,
      String localidade,
      String uf) {
    this.cep = cep;
    this.logradouro = logradouro;
    this.complemento = complemento;
    this.bairro = bairro;
    this.localidade = localidade;
    this.uf = uf;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getLocalidade() {
    return localidade;
  }

  public void setLocalidade(String localidade) {
    this.localidade = localidade;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Endereco endereco = (Endereco) o;
    return Objects.equals(cep, endereco.cep) && Objects.equals(logradouro,
        endereco.logradouro) && Objects.equals(complemento, endereco.complemento)
        && Objects.equals(bairro, endereco.bairro) && Objects.equals(localidade,
        endereco.localidade) && Objects.equals(uf, endereco.uf);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cep, logradouro, complemento, bairro, localidade, uf);
  }

  @Override
  public String toString() {
    return "Endereco{ " +
        "cep='" + cep + '\'' +
        ", logradouro='" + logradouro + '\'' +
        ", complemento='" + complemento + '\'' +
        ", bairro='" + bairro + '\'' +
        ", localidade='" + localidade + '\'' +
        ", uf='" + uf + '\'' +
        " }";
  }

  public static Builder builder() { return new Builder(); }

  public final static class Builder {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    private Builder() {}

    public Builder cep(String cep) {
      this.cep = cep;
      return this;
    }

    public Builder logradouro(String logradouro) {
      this.logradouro = logradouro;
      return this;
    }
    public Builder complemento(String complemento) {
      this.complemento = complemento;
      return this;
    }
    public Builder bairro(String bairro) {
      this.bairro = bairro;
      return this;
    }
    public Builder localidade(String localidade) {
      this.localidade = localidade;
      return this;
    }
    public Builder uf(String uf) {
      this.uf = uf;
      return this;
    }

    public Endereco build() {
      return new Endereco(this.cep, this.logradouro, this.complemento,
          this.bairro, this.localidade, this.uf);
    }
  }
}
