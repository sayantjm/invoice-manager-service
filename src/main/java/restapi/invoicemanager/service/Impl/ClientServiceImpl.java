package restapi.invoicemanager.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restapi.invoicemanager.domain.Client;
import restapi.invoicemanager.dto.ClientDTO;
import restapi.invoicemanager.repository.ClientRepository;
import restapi.invoicemanager.service.ClientService;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    @Override
    public ClientDTO createNew(ClientDTO clientDTO) {
        return repository.save(clientDTO);
    }

    public ClientDTO findById(Long id) {
        ClientDTO result = ClientDTO.builder().build();

        Optional<Client> byId = repository.findById(id);
        if (byId.isPresent()) {
            result = byId.get().toDto();
        }
        return result;
    }
}
