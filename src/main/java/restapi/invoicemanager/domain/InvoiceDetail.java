package restapi.invoicemanager.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import restapi.invoicemanager.dto.InvoiceDetailDTO;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name="INVOICE_DETAIL")
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDetail {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

//    @ManyToMany
//    private Construction construction;

    public InvoiceDetailDTO toDto() {
        return InvoiceDetailDTO.builder().id(this.id).build();
    }

    public void fromDto(InvoiceDetailDTO invoiceDetailDTO) {
        this.id = invoiceDetailDTO.getId();
    }
}
