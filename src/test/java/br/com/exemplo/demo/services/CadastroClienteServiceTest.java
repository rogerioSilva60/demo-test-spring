package br.com.exemplo.demo.services;


import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import br.com.exemplo.demo.clients.CepClient;
import br.com.exemplo.demo.clients.CepSOAPClient;
import br.com.exemplo.demo.dtos.ClienteWeb;
import br.com.exemplo.demo.entities.Cliente;
import br.com.exemplo.demo.mapper.ClienteMapper;
import br.com.exemplo.demo.mother.ClienteMother;
import br.com.exemplo.demo.repositories.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CadastroClienteServiceTest {

  @InjectMocks
  CadastroClienteService cadastroClienteService;
  @Mock
  ClienteRepository clienteRepository;

  @Autowired
  ModelMapper modelMapper;
  @Autowired
  ClienteMapper clienteMapper;
  @Autowired
  CepSOAPClient cepSOAPClient;
  @Autowired
  CepClient cepClient;

  @Nested
  class CadastroComClienteMaiorDeIdade {

    @Spy
    Cliente cliente = ClienteMother.clienteNovoMaiorDeIdade().build();
    @Spy
    ClienteWeb clienteWeb = new ClienteWeb(cliente.getNome(),
        cliente.getDataDeNascimento(), "01001000");

    @BeforeEach
    void setUp(){
      cadastroClienteService = new CadastroClienteService(clienteRepository, modelMapper,
          clienteMapper, cepSOAPClient, cepClient);
      when(clienteRepository.salvar(any(Cliente.class)))
          .thenAnswer(invocacao -> {
            Cliente clientePassado = invocacao.getArgument(0, Cliente.class);
            clientePassado.setId(1L);
            return clientePassado;
          });
    }

    @Test
    void DadoClienteMaiorDeIdadeQuandoSalvarEntaoDeveRetornarUmIdDeCadastro() {
      Cliente retorno = cadastroClienteService.salvar(clienteWeb);
      assertThat(retorno.getId()).isEqualTo(1L);
    }

    @Test
    void DadoClienteMaiorDeIdadeQuandoSalvarEntaoDeveVerificarMetodoDeArmazenamento() {
      cadastroClienteService.salvar(clienteWeb);
      verify(clienteRepository, times(1)).salvar(any(Cliente.class));
    }
  }

  @Nested
  class CadastroComClienteMenorDeIdade {

    @Spy
    Cliente cliente = ClienteMother.clienteNovoMenorDeIdade().build();
    @Spy
    ClienteWeb clienteWeb = new ClienteWeb(cliente.getNome(),
        cliente.getDataDeNascimento(), "01001000");

    @Test
    void DadoClienteMenorDeIdadeQuandoSalvarEntaoNaoDeveSerSalvo() {
      Throwable excecao = catchThrowable(() -> cadastroClienteService.salvar(clienteWeb));
      assertThat(excecao)
          .isInstanceOf(RuntimeException.class)
          .hasMessage("Obrigatório ser maior de 18 anos para se cadastrar nos sistema!");
    }
  }
}