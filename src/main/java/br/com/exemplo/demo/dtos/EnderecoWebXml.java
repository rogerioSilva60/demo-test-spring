package br.com.exemplo.demo.dtos;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "xmlcep")
public class EnderecoWebXml{
    @JacksonXmlProperty(localName = "cep")
    private String cep;
    @JacksonXmlProperty(localName = "logradouro")
    private String logradouro;
    @JacksonXmlProperty(localName = "complemento")
    private String complemento;
    @JacksonXmlProperty(localName = "bairro")
    private String bairro;
    @JacksonXmlProperty(localName = "localidade")
    private String localidade;
    @JacksonXmlProperty(localName = "uf")
    private String uf;
    @JacksonXmlProperty(localName = "ibge")
    private String ibge;
    @JacksonXmlProperty(localName = "gia")
    private String gia;
    @JacksonXmlProperty(localName = "ddd")
    private String ddd;
    @JacksonXmlProperty(localName = "siafi")
    private String siafi;

    public EnderecoWebXml() {}

    public EnderecoWebXml(String cep, String logradouro, String complemento, String bairro,
        String localidade, String uf, String ibge, String gia, String ddd, String siafi) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.ibge = ibge;
        this.gia = gia;
        this.ddd = ddd;
        this.siafi = siafi;
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

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getSiafi() {
        return siafi;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }
}
