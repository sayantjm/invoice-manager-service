package restapi.invoicemanager.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import restapi.invoicemanager.domain.Client;
import restapi.invoicemanager.dto.ClientDTO;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository repository;

    @Before
    public void setup() throws Exception {

    }

    @Test
    public void persistClient() throws Exception {
        ClientDTO clientDTO = ClientDTO.builder()
                .name("clientTest")
                .cif("123456789Z")
                .address("San Juan Street")
                .codPostal(46000)
                .city("Valencia")
                .state("Valencia")
                .phoneNumber("+3496 111 11 11")
                .mobil("123454321")
                .build();

        ClientDTO persistedDto = repository.save(clientDTO);
        Client expected = repository.findById(persistedDto.getId()).get();
        ClientDTO foundDto = expected.toDto();

        assertEquals(persistedDto, foundDto);
    }
}
