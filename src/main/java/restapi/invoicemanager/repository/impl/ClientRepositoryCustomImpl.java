package restapi.invoicemanager.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import restapi.invoicemanager.domain.Client;
import restapi.invoicemanager.dto.ClientDTO;
import restapi.invoicemanager.repository.ClientRepositoryCustom;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepositoryCustomImpl implements ClientRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        Client client = new Client();
        client.fromDto(clientDTO);
        entityManager.persist(client);
        return client.toDto();
    }

    @Override
    public List<ClientDTO> save(List<ClientDTO> listClientDTO) {
        List<ClientDTO> listResult = new ArrayList<>();

        listClientDTO.stream().forEach(clientDto -> {
            Client client = new Client();
            client.fromDto(clientDto);
            entityManager.persist(client);
            listResult.add(client.toDto());
        });
        return listResult;
    }
}
