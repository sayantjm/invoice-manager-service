package restapi.invoicemanager.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import restapi.invoicemanager.domain.Client;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ClientDTOTest {

    @Test
    public void fromDtoTest() {
        ClientDTO clientDTO = ClientDTO.builder()
                .id(1L)
                .name("clientTest")
                .cif("123456789Z")
                .address("San Juan Street")
                .codPostal(46000)
                .city("Valencia")
                .state("Valencia")
                .phoneNumber("+3496 111 11 11")
                .mobil("123454321")
                .build();

        Client client = new Client();
        client.fromDto(clientDTO);

        assertValidations(client, clientDTO);
    }

    @Test
    public void toDtoTest() {
        Client client = Client.builder()
                .id(1L)
                .name("clientTest")
                .cif("123456789Z")
                .address("San Juan Street")
                .codPostal(46000)
                .city("Valencia")
                .state("Valencia")
                .phoneNumber("+3496 111 11 11")
                .mobil("123454321")
                .build();

        ClientDTO clientDTO = client.toDto();

        assertValidations(client, clientDTO);
    }

    private void assertValidations(Client client, ClientDTO clientDTO) {
        assertEquals(client.getId(), clientDTO.getId());
        assertEquals(client.getName(), clientDTO.getName());
        assertEquals(client.getCif(), clientDTO.getCif());
        assertEquals(client.getAddress(), clientDTO.getAddress());
        assertEquals(client.getCodPostal(), clientDTO.getCodPostal());
        assertEquals(client.getCity(), clientDTO.getCity());
        assertEquals(client.getState(), clientDTO.getState());
        assertEquals(client.getPhoneNumber(), clientDTO.getPhoneNumber());
        assertEquals(client.getMobil(), clientDTO.getMobil());
    }
}
