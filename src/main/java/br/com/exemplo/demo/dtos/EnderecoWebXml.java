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

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private String cep;
        private String logradouro;
        private String complemento;
        private String bairro;
        private String localidade;
        private String uf;
        private String ibge;
        private String gia;
        private String ddd;
        private String siafi;

        private Builder() {}

        public  Builder cep(String cep) {
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

        public Builder ibge(String ibge) {
            this.ibge = ibge;
            return this;
        }

        public Builder gia(String gia) {
            this.gia = gia;
            return this;
        }

        public Builder ddd(String ddd) {
            this.ddd = ddd;
            return this;
        }

        public Builder siafi(String siafi) {
            this.siafi = siafi;
            return this;
        }

        public EnderecoWebXml build() {
            return new EnderecoWebXml(this.cep, this.logradouro, this.complemento, this.bairro,
                this.localidade, this.uf, this.ibge, this.gia, this.ddd, this.siafi);
        }
    }
}
