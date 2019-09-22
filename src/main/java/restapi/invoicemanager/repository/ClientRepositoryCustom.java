package restapi.invoicemanager.repository;

import restapi.invoicemanager.dto.ClientDTO;

public interface ClientRepositoryCustom {
    ClientDTO save(ClientDTO clientDTO);
}
