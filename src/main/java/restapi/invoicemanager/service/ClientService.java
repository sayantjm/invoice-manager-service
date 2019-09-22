package restapi.invoicemanager.service;

import restapi.invoicemanager.dto.ClientDTO;

public interface ClientService {
    ClientDTO createNew(ClientDTO clientDTO);
    public ClientDTO findById(Long id);
}
