package restapi.invoicemanager.service;

import restapi.invoicemanager.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO createNew(ClientDTO clientDTO);
    ClientDTO findById(Long id);
    List<ClientDTO> findAll();

}
