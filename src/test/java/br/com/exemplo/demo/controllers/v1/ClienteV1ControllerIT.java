package br.com.exemplo.demo.controllers.v1;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static org.assertj.core.api.Assertions.assertThat;

import br.com.exemplo.demo.dtos.ClienteWeb;
import br.com.exemplo.demo.mother.ClienteWebMother;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ClienteV1ControllerIT {

  private static final String BASE_PATH = "/api/v1/clientes";
  @LocalServerPort
  private int serverPort;

  @Spy
  ClienteWeb clienteWeb = ClienteWebMother.clienteWebNovoMaiorDeIdade().build();

  @BeforeEach
  void setUp() {
    enableLoggingOfRequestAndResponseIfValidationFails();
    port = serverPort;
    basePath = BASE_PATH;
  }

  @Test
  void DadoClienteMaiorDeIdadeQuandoSalvarEntaoRetorneUmID() {
    String location = given()
                .contentType(ContentType.JSON)
                .body(clienteWeb)
              .when()
                .post()
              .then()
                .statusCode(HttpStatus.CREATED.value())
                  .extract()
                  .header("Location");

    assertThat(location).isNotNull();
    assertThat(isNumero(getUltimoCaracter(location))).isTrue();
  }

  private static boolean isNumero(String texto) {
    return texto.matches("[0-9]");
  }
  private static String getUltimoCaracter(String texto) {
    return StringUtils.right(texto, 1);
  }
}