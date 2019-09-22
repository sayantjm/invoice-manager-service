package restapi.invoicemanager.dto;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import restapi.invoicemanager.domain.Client;
import restapi.invoicemanager.domain.Contractor;
import restapi.invoicemanager.domain.Invoice;
import restapi.invoicemanager.domain.InvoiceDetail;

import java.util.Date;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceDTOTest {
    private ClientDTO clientDTO;
    private Client client;
    private ContractorDTO contractorDTO;
    private Contractor contractor;

    @Before
    public void setup() {
        // ClientDTO creation
        this.clientDTO = ClientDTO.builder()
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

        // Client creation
        this.client = Client.builder()
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

        // ContractorDTO creation
        this.contractorDTO = ContractorDTO.builder()
                .id(1L)
                .name("contractorTEST")
                .dni("123456789T")
                .address("MyStreet street")
                .city("cityTest")
                .codPostal(46111)
                .state("stateTest")
                .bankAccount("ES10 1234 1234 1234 1234567899")
                .build();

        // Contractor creation
        this.contractor = Contractor.builder()
                .id(1L)
                .name("contractorTEST")
                .dni("123456789T")
                .address("MyStreet street")
                .city("cityTest")
                .codPostal(46111)
                .state("stateTest")
                .bankAccount("ES10 1234 1234 1234 1234567899")
                .build();
    }

    @Test
    public void fromDtoTest() {
        // InvoiceDTO creation
        InvoiceDTO invoiceDTO = InvoiceDTO.builder()
                .id(1L)
                .createdDate(new Date())
                .invoiceNumber("2019/01")
                .percentageIVA(21.00)
                .client(this.clientDTO)
                .contractor(this.contractorDTO).build();

        InvoiceDetailDTO invoiceDetailDTO = InvoiceDetailDTO.builder().id(1L).build();
        invoiceDTO.setDetails(new HashSet<>());
        invoiceDTO.getDetails().add(invoiceDetailDTO);

        Invoice invoice = new Invoice();
        invoice.fromDto(invoiceDTO);

        assertValidations(invoice, invoiceDTO);
    }

    @Test
    public void toDtoTest() {
        Invoice invoice = Invoice.builder()
                .id(1L)
                .createdDate(new Date())
                .invoiceNumber("2019/01")
                .percentageIVA(21.00)
                .client(this.client)
                .contractor(this.contractor)
                .build();

        InvoiceDetail invoiceDetail = InvoiceDetail.builder().id(1L).invoice(invoice).build();
        invoice.setDetails(new HashSet<>());
        invoice.getDetails().add(invoiceDetail);

        InvoiceDTO invoiceDTO = invoice.toDto();

        assertValidations(invoice, invoiceDTO);
    }

    public void assertValidations(Invoice invoice, InvoiceDTO invoiceDTO) {
        assertEquals(invoice.getId(), invoiceDTO.getId());
        assertEquals(invoice.getCreatedDate(), invoiceDTO.getCreatedDate());
        assertEquals(invoice.getInvoiceNumber(), invoiceDTO.getInvoiceNumber());
        assertEquals(invoice.getPercentageIVA(), invoiceDTO.getPercentageIVA());
        assertEquals(invoice.getClient().toDto(), invoiceDTO.getClient());
        assertEquals(invoice.getContractor().toDto(), invoiceDTO.getContractor());
        assertEquals(invoice.getDetails().iterator().next().toDto(), invoiceDTO.getDetails().iterator().next());
    }
}
