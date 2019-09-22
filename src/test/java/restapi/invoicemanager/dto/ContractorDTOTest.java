package restapi.invoicemanager.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import restapi.invoicemanager.domain.Contractor;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ContractorDTOTest {

    @Test
    public void fromDto() {
        ContractorDTO contractorDTO = ContractorDTO.builder()
                .id(1L)
                .name("contractorTEST")
                .dni("123456789T")
                .address("MyStreet street")
                .city("cityTest")
                .codPostal(46111)
                .state("stateTest")
                .bankAccount("ES10 1234 1234 1234 1234567899")
                .build();

        Contractor contractor = new Contractor();
        contractor.fromDto(contractorDTO);

        assertValidations(contractor, contractorDTO);
    }

    @Test
    public void toDto() {
        Contractor contractor = Contractor.builder()
                .id(1L)
                .name("contractorTEST")
                .dni("123456789T")
                .address("MyStreet street")
                .city("cityTest")
                .codPostal(46111)
                .state("stateTest")
                .bankAccount("ES10 1234 1234 1234 1234567899")
                .build();

        ContractorDTO contractorDTO = contractor.toDto();

        assertValidations(contractor, contractorDTO);
    }

    private void assertValidations(Contractor contractor, ContractorDTO contractorDTO) {
        assertEquals(contractor.getId(), contractorDTO.getId());
        assertEquals(contractor.getName(), contractorDTO.getName());
        assertEquals(contractor.getAddress(), contractorDTO.getAddress());
        assertEquals(contractor.getBankAccount(), contractorDTO.getBankAccount());
        assertEquals(contractor.getCity(), contractorDTO.getCity());
        assertEquals(contractor.getCodPostal(), contractorDTO.getCodPostal());
        assertEquals(contractor.getDni(), contractorDTO.getDni());
        assertEquals(contractor.getState(), contractorDTO.getState());
    }
}
