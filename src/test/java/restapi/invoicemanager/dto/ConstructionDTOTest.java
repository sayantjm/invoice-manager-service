package restapi.invoicemanager.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import restapi.invoicemanager.domain.Construction;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ConstructionDTOTest {

    @Test
    public void fromDtoTest() {
        ConstructionDTO constructionDTO = ConstructionDTO.builder().id(1L).name("constructionTest").build();

        Construction construction = new Construction();
        construction.fromDto(constructionDTO);

        assertValidations(construction, constructionDTO);
    }

    @Test
    public void toDtoTest() {

        Construction construction = Construction.builder().id(1L).name("constructionTest").build();
        ConstructionDTO constructionDTO = construction.toDto();

        assertValidations(construction, constructionDTO);
    }

    private void assertValidations(Construction construction, ConstructionDTO constructionDTO) {
        assertEquals(construction.getId(), constructionDTO.getId());
        assertEquals(construction.getName(), constructionDTO.getName());
    }
}
