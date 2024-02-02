package br.com.exemplo.demo.mapper;

import br.com.exemplo.demo.dtos.ClienteWeb;
import br.com.exemplo.demo.dtos.EnderecoWeb;
import br.com.exemplo.demo.dtos.EnderecoWebXml;
import br.com.exemplo.demo.entities.Cliente;
import br.com.exemplo.demo.entities.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ClienteMapper {

  Cliente toCliente(ClienteWeb clienteWeb);

  Endereco toEndereco(EnderecoWeb enderecoWeb);

  Endereco toEndereco(EnderecoWebXml enderecoWebXml);
}
