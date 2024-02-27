package vitomir.hardi.compingtest.compingcrudtest.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import vitomir.hardi.compingtest.compingcrudtest.dto.WebSiteServiceDescriptionOnlyDTO;
import vitomir.hardi.compingtest.compingcrudtest.model.WebSiteService;
import vitomir.hardi.compingtest.compingcrudtest.model.WebSiteServiceProvider;

import java.util.Collection;
import java.util.List;

@Repository
public interface WebSiteServiceRepository extends CrudRepository<WebSiteService, Long>, JpaSpecificationExecutor<WebSiteService> {
    //Flux<WebSiteService> findAllByDescriptionServiceAndProviders_Name(String descriptionService, String providerName);
    //<T> Collection<T> findAll(Class<T> type);
    @Query("SELECT s.descriptionService as descriptionService,s.id as id FROM WebSiteService s")
    List<WebSiteServiceDescriptionOnlyDTO> findAllServiceDescriptions();

}