package vitomir.hardi.compingtest.compingcrudtest.service;

import vitomir.hardi.compingtest.compingcrudtest.dto.WebSiteServiceDescriptionOnlyDTO;
import vitomir.hardi.compingtest.compingcrudtest.model.WebSiteService;

import java.util.Optional;

public interface WebSiteServiceService {


    Iterable<WebSiteServiceDescriptionOnlyDTO> getAllServices();

    Optional<WebSiteService> getServiceById(Long id);

    WebSiteService createService(WebSiteService service);

    WebSiteService updateService(Long id, WebSiteService service);

    void deleteService(Long id);

    Iterable<WebSiteService> findByDescription(String descriptionService);

  //  Flux<WebSiteService> getFilteredServices(Map<String, String> searchParams);
}
