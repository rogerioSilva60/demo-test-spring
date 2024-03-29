package br.com.exemplo.demo.dtos;


public class EnderecoWeb{
  private String cep;
  private String logradouro;
  private String complemento;
  private String bairro;
  private String localidade;
  private String uf;

  public EnderecoWeb() {}

  public EnderecoWeb(String cep, String logradouro, String complemento, String bairro,
      String localidade, String uf) {
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

  public static EnderecoWeb.Builder builder() { return new EnderecoWeb.Builder(); }

  public static final class Builder {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    private Builder() {}

    public EnderecoWeb.Builder cep(String cep) {
      this.cep = cep;
      return this;
    }

    public EnderecoWeb.Builder logradouro(String logradouro) {
      this.logradouro = logradouro;
      return this;
    }

    public EnderecoWeb.Builder complemento(String complemento) {
      this.complemento = complemento;
      return this;
    }

    public EnderecoWeb.Builder bairro(String bairro) {
      this.bairro = bairro;
      return this;
    }

    public EnderecoWeb.Builder localidade(String localidade) {
      this.localidade = localidade;
      return this;
    }

    public EnderecoWeb.Builder uf(String uf) {
      this.uf = uf;
      return this;
    }

    public EnderecoWeb build() {
      return new EnderecoWeb(this.cep, this.logradouro, this.complemento, this.bairro,
          this.localidade, this.uf);
    }
  }
}
