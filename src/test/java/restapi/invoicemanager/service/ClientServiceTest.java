package restapi.invoicemanager.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import restapi.invoicemanager.dto.ClientDTO;
import restapi.invoicemanager.repository.ClientRepository;
import restapi.invoicemanager.utils.databuilder.ClientDTOBuilder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @Mock
    private ClientRepository repository;

    @Before
    public void setup() {
        ClientDTO clientDTO = new ClientDTOBuilder().getDefault();
        //when(repository.save(Mockito.any())).thenReturn(clientDTO);
    }

    @Test
    public void createNewClient() {
        ClientDTO clientDTO = new ClientDTOBuilder().getDefault();

        ClientDTO createdDTO = clientService.createNew(clientDTO);

        assertEquals(clientDTO, createdDTO);
    }

    @Test
    public void findByIdTest() {
        Long id = 1L;

        ClientDTO clientDTO = new ClientDTOBuilder().getDefault();
        ClientDTO createdDTO = clientService.createNew(clientDTO);

        ClientDTO foundClient = clientService.findById(id);
        assertEquals(foundClient, createdDTO);
    }
}
