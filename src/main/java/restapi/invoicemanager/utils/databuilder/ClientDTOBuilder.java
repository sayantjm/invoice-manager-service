package restapi.invoicemanager.utils.databuilder;

import lombok.Data;
import restapi.invoicemanager.dto.ClientDTO;

@Data
public class ClientDTOBuilder {
    private ClientDTO clientDto;

    public ClientDTOBuilder() { this.clientDto = getDefault(); }

    public ClientDTO build() { return this.clientDto; }

    public ClientDTO getDefault() {
        return ClientDTO.builder()
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
    }

}
