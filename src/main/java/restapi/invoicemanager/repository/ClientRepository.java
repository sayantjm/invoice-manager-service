package restapi.invoicemanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import restapi.invoicemanager.domain.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>, ClientRepositoryCustom {
}
