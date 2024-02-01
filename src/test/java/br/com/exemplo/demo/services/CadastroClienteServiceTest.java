package br.com.exemplo.demo.services;


import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import br.com.exemplo.demo.entities.Cliente;
import br.com.exemplo.demo.mother.ClienteMother;
import br.com.exemplo.demo.repositories.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CadastroClienteServiceTest {

  @InjectMocks
  CadastroClienteService cadastroClienteService;
  @Mock
  ClienteRepository clienteRepository;

  @Nested
  class CadastroComClienteMaiorDeIdade {

    @Spy
    Cliente cliente = ClienteMother.clienteNovoMaiorDeIdade().build();

    @BeforeEach
    void setUp(){
      when(clienteRepository.salvar(cliente))
          .thenAnswer(invocacao -> {
            Cliente clientePassado = invocacao.getArgument(0, Cliente.class);
            clientePassado.setId(1L);
            return clientePassado;
          });
    }

    @Test
    void DadoClienteMaiorDeIdadeQuandoSalvarEntaoDeveRetornarUmIdDeCadastro() {
      Cliente retorno = cadastroClienteService.salvar(cliente);
      assertThat(retorno.getId()).isEqualTo(1L);
    }

    @Test
    void DadoClienteMaiorDeIdadeQuandoSalvarEntaoDeveVerificarOMetodoDeArmazenamento() {
      cadastroClienteService.salvar(cliente);
      verify(clienteRepository, times(1)).salvar(cliente);
    }
  }

  @Nested
  class CadastroComClienteMenorDeIdade {

    @Spy
    Cliente cliente = ClienteMother.clienteNovoMenorDeIdade().build();

    @Test
    void DadoClienteMenorDeIdadeQuandoSalvarEntaoDeveRetornarUmRuntimeException() {
      Throwable excecao = catchThrowable(() -> cadastroClienteService.salvar(cliente));
      assertThat(excecao)
          .isInstanceOf(RuntimeException.class)
          .hasMessage("Obrigatório ser maior de 18 anos para se cadastrar nos sistema!");
    }
  }
}