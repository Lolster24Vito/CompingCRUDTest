package vitomir.hardi.compingtest.compingcrudtest.service;

import vitomir.hardi.compingtest.compingcrudtest.dto.WebSiteServiceProviderNameOnlyDTO;
import vitomir.hardi.compingtest.compingcrudtest.model.WebSiteServiceProvider;

import java.util.Optional;

public interface WebSiteServiceProviderService {
    Iterable<WebSiteServiceProviderNameOnlyDTO> getAllServiceProviders();

    Optional<WebSiteServiceProvider> getServiceProviderById(Long id);

    WebSiteServiceProvider createServiceProvider(WebSiteServiceProvider service);

    WebSiteServiceProvider updateServiceProvider(Long id, WebSiteServiceProvider service);

    void deleteServiceProvider(Long id);
    Iterable<WebSiteServiceProvider> findByName(String name);

}
