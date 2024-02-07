package br.com.exemplo.demo.controllers.v1.openapi;

import br.com.exemplo.demo.dtos.ClienteWeb;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Cliente", description = "Serviços relacionados ao cliente")
public interface ClienteV1OpenAPI {

  @Operation(summary = "Salvar o cliente", description = "Deve salvar o cliente")
  @ApiResponses(
      value = {
          @ApiResponse (
              responseCode = "201", description = "Cliente cadastrado", content = @Content
          ),
          @ApiResponse (
              responseCode = "400", description = "Requisição inválida", content = @Content
          ),
          @ApiResponse (
              responseCode = "500", description = "Ocorreu erro interno", content = @Content
          )
      }
  )
  ResponseEntity<Void> salvar(@RequestBody(required = true) ClienteWeb clienteWeb);

}
