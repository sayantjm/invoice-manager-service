package restapi.invoicemanager.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import restapi.invoicemanager.dto.ContractorDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="CONTRACTOR")
public class Contractor {
    @Id
    private Long id;

    private String name;
    private String dni;
    private String address;
    private String city;
    private Integer codPostal;
    private String state;
    private String bankAccount;

    public ContractorDTO toDto() {
        return ContractorDTO.builder()
                .id(this.id)
                .name(this.name)
                .dni(this.dni)
                .address(this.address)
                .city(this.city)
                .codPostal(this.codPostal)
                .state(this.state)
                .bankAccount(this.bankAccount)
                .build();
    }

    public void fromDto(ContractorDTO contractorDTO) {
        this.id = contractorDTO.getId();
        this.name = contractorDTO.getName();
        this.dni = contractorDTO.getDni();
        this.address = contractorDTO.getAddress();
        this.city = contractorDTO.getCity();
        this.codPostal = contractorDTO.getCodPostal();
        this.state = contractorDTO.getState();
        this.bankAccount = contractorDTO.getBankAccount();
    }
}
