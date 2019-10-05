package restapi.invoicemanager.service;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import restapi.invoicemanager.domain.Client;
import restapi.invoicemanager.dto.ClientDTO;
import restapi.invoicemanager.repository.ClientRepository;
import restapi.invoicemanager.service.Impl.ClientServiceImpl;
import restapi.invoicemanager.utils.databuilder.ClientDTOBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

    @InjectMocks
    private ClientServiceImpl clientService;

    @Mock
    private ClientRepository repository;

    @Before
    public void setup() {
        ClientDTO clientDTO = new ClientDTOBuilder().getDefault();
        when(repository.save(Mockito.any(ClientDTO.class))).thenReturn(clientDTO);
    }

    @Test
    public void createNewClient() {
        ClientDTO clientDTO = new ClientDTOBuilder().getDefault();

        ClientDTO createdDTO = clientService.createNew(clientDTO);

        assertEquals(clientDTO, createdDTO);
    }

    @Test
    @Ignore
    public void findByIdTest() {
        Long id = 1L;

        ClientDTO clientDTO = new ClientDTOBuilder().getDefault();
        ClientDTO createdDTO = clientService.createNew(clientDTO);

        ClientDTO foundClient = clientService.findById(id);
        assertEquals(foundClient, createdDTO);
    }

    @Test
    @Ignore
    public void findAllTest() {
        ClientDTO clientDTO1 = new ClientDTOBuilder().getDefault();
        ClientDTO clientDTO2 = new ClientDTOBuilder().getDefault();
        clientDTO2.setId(2L);
        clientDTO2.setName("client2");
        List<ClientDTO> listClients = Arrays.asList(clientDTO1, clientDTO2);
        List<ClientDTO> persistedClients = repository.save(listClients);
        assertEquals(persistedClients.get(0), listClients.get(0));
        assertEquals(persistedClients.get(1), listClients.get(1));
    }
}
