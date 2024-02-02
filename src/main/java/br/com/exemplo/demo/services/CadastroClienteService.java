package br.com.exemplo.demo.services;

import br.com.exemplo.demo.clients.CepClient;
import br.com.exemplo.demo.clients.CepSOAPClient;
import br.com.exemplo.demo.dtos.ClienteWeb;
import br.com.exemplo.demo.dtos.EnderecoWeb;
import br.com.exemplo.demo.dtos.EnderecoWebXml;
import br.com.exemplo.demo.entities.Cliente;
import br.com.exemplo.demo.entities.Endereco;
import br.com.exemplo.demo.mapper.ClienteMapper;
import br.com.exemplo.demo.repositories.ClienteRepository;
import java.time.LocalDate;
import java.time.Period;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class CadastroClienteService {

  private static final Logger logger = LogManager.getLogger(CadastroClienteService.class);
  public static final int IDADE_PERMITIDA = 18;
  private final ClienteRepository clienteRepository;
  private final ModelMapper modelMapper;
  private final ClienteMapper clienteMapper;
  private final CepSOAPClient cepSOAPClient;
  private final CepClient cepClient;

  public CadastroClienteService(ClienteRepository clienteRepository, ModelMapper modelMapper,
      ClienteMapper clienteMapper, CepSOAPClient cepSOAPClient,
      CepClient cepClient) {
    this.clienteRepository = clienteRepository;
    this.modelMapper = modelMapper;
    this.clienteMapper = clienteMapper;
    this.cepSOAPClient = cepSOAPClient;
    this.cepClient = cepClient;
  }

  public Cliente salvar(@NonNull ClienteWeb clienteWeb) throws RuntimeException {

    if(IDADE_PERMITIDA > getIdade(clienteWeb.getDataDeNascimento()))
      throw new RuntimeException("Obrigatório ser maior de 18 anos para se cadastrar nos sistema!");

    getEndenrecoViaSOAP(clienteWeb.getCep());

    Endereco endereco = getEnderecoViaJSON(clienteWeb.getCep());

    Cliente cliente = modelMapper.map(clienteWeb, Cliente.class);
    cliente.setEndereco(endereco);

    Cliente clienteViaMapStruct = clienteMapper.toCliente(clienteWeb);
    cliente.setEndereco(endereco);

    return clienteRepository.salvar(cliente);
  }

  private int getIdade(LocalDate dataDeNascimento) {
    return Period.between(dataDeNascimento, LocalDate.now()).getYears();
  }

  private Endereco getEndenrecoViaSOAP(String cep) {
    EnderecoWebXml enderecoWebXml = cepSOAPClient.getEndereco(cep);
    logger.info("Via XML -> {}", enderecoWebXml);
    Endereco enderecoViaMapStruct = clienteMapper.toEndereco(enderecoWebXml);
    return modelMapper.map(enderecoWebXml, Endereco.class);
  }

  private Endereco getEnderecoViaJSON(String cep) {
    ResponseEntity<EnderecoWeb> enderecoJson = cepClient.getEndereco(cep);
    logger.info("Via JSON -> {}", enderecoJson);
    Endereco enderecoViaMapStruct = clienteMapper.toEndereco(enderecoJson.getBody());
    return modelMapper.map(enderecoJson.getBody(), Endereco.class);
  }
}
