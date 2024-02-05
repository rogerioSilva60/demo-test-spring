package br.com.exemplo.demo.services;


import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import br.com.exemplo.demo.clients.CepClient;
import br.com.exemplo.demo.clients.CepSOAPClient;
import br.com.exemplo.demo.dtos.ClienteWeb;
import br.com.exemplo.demo.dtos.EnderecoWeb;
import br.com.exemplo.demo.dtos.EnderecoWebXml;
import br.com.exemplo.demo.entities.Cliente;
import br.com.exemplo.demo.mapper.ClienteMapper;
import br.com.exemplo.demo.mother.ClienteWebMother;
import br.com.exemplo.demo.mother.EnderecoWebMother;
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
import org.springframework.http.ResponseEntity;

@SpringBootTest
class CadastroClienteServiceTest {

  @InjectMocks
  CadastroClienteService cadastroClienteService;
  @Mock
  ClienteRepository clienteRepository;
  @Mock
  CepSOAPClient cepSOAPClient;
  @Mock
  CepClient cepClient;

  @Nested
  class CadastroComClienteMaiorDeIdade {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ClienteMapper clienteMapper;

    @Spy
    ClienteWeb clienteWeb = ClienteWebMother.clienteWebNovoMaiorDeIdade().build();
    @Spy
    EnderecoWebXml enderecoWebXml = EnderecoWebMother.enderecoWebXmlNovo()
        .cep(clienteWeb.getCep())
        .build();
    @Spy
    EnderecoWeb enderecoWebJson = EnderecoWebMother.enderecoWebJsonNovo()
        .cep(clienteWeb.getCep())
        .build();

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
      when(cepSOAPClient.getEndereco(clienteWeb.getCep())).thenReturn(enderecoWebXml);
      when(cepClient.getEndereco(clienteWeb.getCep())).thenReturn(ResponseEntity.ok(enderecoWebJson));
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

    @Test
    void DadoClienteMaiorDeIdadeQuandoSalvarEntaoDeveVerificarGetEnderecoViaSOAP() {
      cadastroClienteService.salvar(clienteWeb);
      verify(cepSOAPClient, atLeast(1)).getEndereco(clienteWeb.getCep());
    }

    @Test
    void DadoClienteMaiorDeIdadeQuandoSalvarEntaoDeveVerificarGetEnderecoViaJSON() {
      cadastroClienteService.salvar(clienteWeb);
      verify(cepClient, atLeast(1)).getEndereco(clienteWeb.getCep());
    }
  }

  @Nested
  class CadastroComClienteMenorDeIdade {

    @Spy
    ClienteWeb clienteWeb = ClienteWebMother.clienteWebNovoMenorDeIdade().build();

    @Test
    void DadoClienteMenorDeIdadeQuandoSalvarEntaoNaoDeveSerSalvo() {
      Throwable excecao = catchThrowable(() -> cadastroClienteService.salvar(clienteWeb));
      assertThat(excecao)
          .isInstanceOf(RuntimeException.class)
          .hasMessage("Obrigatório ser maior de 18 anos para se cadastrar nos sistema!");
    }
  }
}