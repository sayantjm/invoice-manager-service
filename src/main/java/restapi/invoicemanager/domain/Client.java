package restapi.invoicemanager.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import restapi.invoicemanager.dto.ClientDTO;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name="CLIENT")
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String cif;
    private String address;
    private Integer codPostal;
    private String city;
    private String state;
    private String phoneNumber;
    private String mobil;

    public ClientDTO toDto() {
        return ClientDTO.builder()
                .id(this.id)
                .name(this.name)
                .cif(this.cif)
                .address(this.address)
                .codPostal(this.codPostal)
                .city(this.city)
                .state(this.state)
                .phoneNumber(this.phoneNumber)
                .mobil(this.mobil)
                .build();
    }

    public void fromDto(ClientDTO clientDTO) {
        this.id = clientDTO.getId();
        this.name = clientDTO.getName();
        this.cif = clientDTO.getCif();
        this.address = clientDTO.getAddress();
        this.codPostal = clientDTO.getCodPostal();
        this.city = clientDTO.getCity();
        this.state = clientDTO.getState();
        this.phoneNumber = clientDTO.getPhoneNumber();
        this.mobil = clientDTO.getMobil();
    }
}
