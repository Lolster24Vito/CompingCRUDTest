package vitomir.hardi.compingtest.compingcrudtest.service.impl;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import vitomir.hardi.compingtest.compingcrudtest.dto.WebSiteServiceDescriptionOnlyDTO;
import vitomir.hardi.compingtest.compingcrudtest.model.WebSiteService;
import vitomir.hardi.compingtest.compingcrudtest.repository.WebSiteServiceRepository;
import vitomir.hardi.compingtest.compingcrudtest.service.WebSiteServiceService;
import vitomir.hardi.compingtest.compingcrudtest.specifications.WebSiteServiceSpecs;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class WebSiteServiceServiceImpl implements WebSiteServiceService {
    private final WebSiteServiceRepository webSiteServiceRepo;

    public WebSiteServiceServiceImpl(WebSiteServiceRepository webSiteServiceRepo) {
        this.webSiteServiceRepo = webSiteServiceRepo;
    }

    @Override
    public Iterable<WebSiteServiceDescriptionOnlyDTO> getAllServices() {
        return  webSiteServiceRepo.findAllServiceDescriptions();
    }

    @Override
    public Optional<WebSiteService> getServiceById(Long id) {
        return webSiteServiceRepo.findById(id);
    }

    @Override
    public WebSiteService createService(WebSiteService service) {
        return webSiteServiceRepo.save(service);
    }

    @Override
    public WebSiteService updateService(Long id, WebSiteService service) {
        Optional<WebSiteService> existingService=webSiteServiceRepo.findById(id);
        if(existingService.isPresent()){
        existingService.get().setDescriptionService(service.getDescriptionService());
        existingService.get().setProviders(service.getProviders());
       return webSiteServiceRepo.save(existingService.get());
        }
        throw new NoSuchElementException("No value present of provided Id:"+id);

    }

    @Override
    public void deleteService(Long id) {
        webSiteServiceRepo.deleteById(id);
    }

    @Override
    public Iterable<WebSiteService> findByDescription(String descriptionService) {
        Specification<WebSiteService> specs=Specification.where((WebSiteServiceSpecs.likeDescriptionService(descriptionService)));
        return webSiteServiceRepo.findAll(specs);
    }

}
