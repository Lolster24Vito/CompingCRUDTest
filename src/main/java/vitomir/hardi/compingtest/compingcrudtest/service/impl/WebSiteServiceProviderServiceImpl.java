package vitomir.hardi.compingtest.compingcrudtest.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vitomir.hardi.compingtest.compingcrudtest.dto.WebSiteServiceProviderNameOnlyDTO;
import vitomir.hardi.compingtest.compingcrudtest.model.WebSiteService;
import vitomir.hardi.compingtest.compingcrudtest.model.WebSiteServiceProvider;
import vitomir.hardi.compingtest.compingcrudtest.repository.WebSiteServiceProviderRepository;
import vitomir.hardi.compingtest.compingcrudtest.repository.WebSiteServiceRepository;
import vitomir.hardi.compingtest.compingcrudtest.service.WebSiteServiceProviderService;
import vitomir.hardi.compingtest.compingcrudtest.specifications.WebSiteServiceProviderSpecs;
import vitomir.hardi.compingtest.compingcrudtest.specifications.WebSiteServiceSpecs;

import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class WebSiteServiceProviderServiceImpl implements WebSiteServiceProviderService {
    private final WebSiteServiceProviderRepository webSiteServiceProviderRepo;
    private final WebSiteServiceRepository webSiteServiceRepository;

    public WebSiteServiceProviderServiceImpl(WebSiteServiceProviderRepository webSiteServiceProviderRepo, WebSiteServiceRepository webSiteServiceRepository) {
        this.webSiteServiceProviderRepo = webSiteServiceProviderRepo;
        this.webSiteServiceRepository = webSiteServiceRepository;
    }

    @Override
    public Iterable<WebSiteServiceProviderNameOnlyDTO> getAllServiceProviders() {
        return webSiteServiceProviderRepo.findAllServiceProvidersNames();
    }

    @Override
    public Optional<WebSiteServiceProvider> getServiceProviderById(Long id) {
        return webSiteServiceProviderRepo.findById(id);
    }

    @Override
    public WebSiteServiceProvider createServiceProvider(WebSiteServiceProvider serviceProvider) {

        return webSiteServiceProviderRepo.save(serviceProvider);
    }

    @Override
    public WebSiteServiceProvider updateServiceProvider(Long id, WebSiteServiceProvider serviceProvider) {
        Optional<WebSiteServiceProvider> existingServiceProvider=webSiteServiceProviderRepo.findById(id);
        if ((existingServiceProvider.isPresent())){
            existingServiceProvider.get().setName(serviceProvider.getName());
            existingServiceProvider.get().setServices(serviceProvider.getServices());
            return webSiteServiceProviderRepo.save(existingServiceProvider.get());
        }
        throw new NoSuchElementException("No value present of provided Id:"+id);
    }

    @Override
    @Transactional
    public void deleteServiceProvider(Long id) {
        WebSiteServiceProvider providerToDelete=webSiteServiceProviderRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("WebSiteServiceProvider not found"));
        for(WebSiteService service:providerToDelete.getServices()){
            service.getProviders().remove(providerToDelete);
            webSiteServiceRepository.save(service);
        }
        providerToDelete.getServices().clear();

        webSiteServiceProviderRepo.deleteById(id);
    }

    @Override
    public Iterable<WebSiteServiceProvider> findByName(String name) {
    Specification<WebSiteServiceProvider> specs=Specification.where(WebSiteServiceProviderSpecs.likeName(name));
    return webSiteServiceProviderRepo.findAll(specs);
    }
}
