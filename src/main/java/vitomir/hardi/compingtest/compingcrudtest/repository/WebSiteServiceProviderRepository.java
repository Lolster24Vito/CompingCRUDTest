package vitomir.hardi.compingtest.compingcrudtest.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vitomir.hardi.compingtest.compingcrudtest.dto.WebSiteServiceDescriptionOnlyDTO;
import vitomir.hardi.compingtest.compingcrudtest.dto.WebSiteServiceProviderNameOnlyDTO;
import vitomir.hardi.compingtest.compingcrudtest.model.WebSiteServiceProvider;

import java.util.List;

@Repository
public interface WebSiteServiceProviderRepository   extends CrudRepository<WebSiteServiceProvider, Long>, JpaSpecificationExecutor<WebSiteServiceProvider> {
    @Query("SELECT sp.name as name,sp.id as id FROM WebSiteServiceProvider sp")
    List<WebSiteServiceProviderNameOnlyDTO> findAllServiceProvidersNames();

}
