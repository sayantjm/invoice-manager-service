package restapi.invoicemanager.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import restapi.invoicemanager.domain.Client;
import restapi.invoicemanager.dto.ClientDTO;
import restapi.invoicemanager.repository.ClientRepository;
import restapi.invoicemanager.service.ClientService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    @Override
    public ClientDTO createNew(ClientDTO clientDTO) {
        return repository.save(clientDTO);
    }

    @Override
    public ClientDTO findById(Long id) {
        ClientDTO result = ClientDTO.builder().build();

        Optional<Client> byId = repository.findById(id);
        if (byId.isPresent()) {
            result = byId.get().toDto();
        }
        return result;
    }

    @Override
    public List<ClientDTO> findAll() {
        List<ClientDTO> resultList = new ArrayList<>();

        List<Client> listClients = repository.findAll();
        if (!StringUtils.isEmpty(listClients)) {
            resultList = listClients.stream().map(client -> client.toDto()).collect(Collectors.toList());
        }
        return resultList;
    }
}
