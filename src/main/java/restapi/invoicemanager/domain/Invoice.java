package restapi.invoicemanager.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import restapi.invoicemanager.dto.InvoiceDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
@Entity
@Table(name="INVOICE")
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Id
    private Long id;

    private Date createdDate;
    private String invoiceNumber;
    private Double percentageIVA;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "contractor_id")
    private Contractor contractor;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<InvoiceDetail> details = new HashSet<>();

    public boolean addDetail(InvoiceDetail detail) {
        detail.setInvoice(this);
        return getDetails().add(detail);
    }

    public void removeDetail(InvoiceDetail detail) {
        getDetails().remove(detail);
    }

    public InvoiceDTO toDto() {
        InvoiceDTO invoiceDTO = InvoiceDTO.builder()
                .id(this.id)
                .createdDate(this.createdDate)
                .invoiceNumber(this.invoiceNumber)
                .percentageIVA(this.percentageIVA)
                .client(this.client.toDto())
                .contractor(this.contractor.toDto()).build();

        invoiceDTO.setDetails(getDetails().stream().map(detail -> detail.toDto()).collect(Collectors.toSet()));
        return invoiceDTO;
    }

    public void fromDto(InvoiceDTO invoiceDTO) {
        this.id = invoiceDTO.getId();
        this.createdDate = invoiceDTO.getCreatedDate();
        this.invoiceNumber = invoiceDTO.getInvoiceNumber();
        this.percentageIVA = invoiceDTO.getPercentageIVA();
        Client client = new Client();
        client.fromDto(invoiceDTO.getClient());
        this.client = client;
        Contractor contractor = new Contractor();
        contractor.fromDto(invoiceDTO.getContractor());
        this.contractor = contractor;
        Set<InvoiceDetail> details = new HashSet<>();

        invoiceDTO.getDetails().forEach(detail -> {
            InvoiceDetail newDetail = new InvoiceDetail();
            newDetail.fromDto(detail);
            details.add(newDetail);
        });
        this.setDetails(details);
    }
}
