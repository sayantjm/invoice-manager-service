package restapi.invoicemanager.repository;

import restapi.invoicemanager.dto.ClientDTO;

import java.util.List;

public interface ClientRepositoryCustom {
    ClientDTO save(ClientDTO clientDTO);
    List<ClientDTO> save(List<ClientDTO> clientDTO);
}
