package br.com.exemplo.demo.clients;

import br.com.exemplo.demo.dtos.EnderecoWeb;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "via-cep",
    url = "${client.soap.url}",
    path = "/ws")
public interface CepClient {

  @GetMapping("/{cep}/json")
  ResponseEntity<EnderecoWeb> getEndereco(@PathVariable("cep") String cep);

}
