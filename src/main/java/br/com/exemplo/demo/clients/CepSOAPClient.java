package br.com.exemplo.demo.clients;

import br.com.exemplo.demo.config.ClientSOAPConfig;
import br.com.exemplo.demo.dtos.EnderecoWebXml;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "via-cep-soap",
    url = "${client.soap.url}",
    path = "/ws",
    configuration = ClientSOAPConfig.class)
public interface CepSOAPClient {

  @GetMapping(value = "/{cep}/xml", consumes = MediaType.APPLICATION_XML_VALUE)
  EnderecoWebXml getEndereco(@PathVariable("cep") String cep);

}
