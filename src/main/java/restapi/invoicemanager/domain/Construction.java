package restapi.invoicemanager.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import restapi.invoicemanager.dto.ConstructionDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@Entity
@Table(name="CONSTRUCTION")
@NoArgsConstructor
@AllArgsConstructor
public class Construction {
    @Id
    private Long id;

    private String name;

    public ConstructionDTO toDto() {
        return ConstructionDTO.builder().id(this.id).name(this.name).build();
    }

    public void fromDto(ConstructionDTO constructionDTO) {
        this.id = constructionDTO.getId();
        this.name = constructionDTO.getName();
    }
}
