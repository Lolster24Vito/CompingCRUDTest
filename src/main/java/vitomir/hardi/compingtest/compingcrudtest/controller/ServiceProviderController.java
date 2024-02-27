package vitomir.hardi.compingtest.compingcrudtest.controller;

import org.springframework.web.bind.annotation.*;
import vitomir.hardi.compingtest.compingcrudtest.dto.WebSiteServiceProviderNameOnlyDTO;
import vitomir.hardi.compingtest.compingcrudtest.model.WebSiteService;
import vitomir.hardi.compingtest.compingcrudtest.model.WebSiteServiceProvider;
import vitomir.hardi.compingtest.compingcrudtest.service.WebSiteServiceProviderService;

import java.util.Optional;

@RestController
@RequestMapping("/api/service-providers")
public class ServiceProviderController {

   private final WebSiteServiceProviderService serviceProviderService;


    public ServiceProviderController(WebSiteServiceProviderService serviceProviderService) {
        this.serviceProviderService = serviceProviderService;
    }

    @GetMapping("/")
    public Iterable<WebSiteServiceProviderNameOnlyDTO> getAllServiceProviders(){
        return serviceProviderService.getAllServiceProviders();
    }


    @GetMapping("/{id}")
    public Optional<WebSiteServiceProvider> getServiceProviderById(@PathVariable Long id) {
        return serviceProviderService.getServiceProviderById(id);
    }

    @PostMapping("/")
    public WebSiteServiceProvider createServiceProvider(@RequestBody WebSiteServiceProvider serviceProvider) {
        return serviceProviderService.createServiceProvider(serviceProvider);
    }

    @PutMapping("/{id}")
    public WebSiteServiceProvider updateServiceProvider(@PathVariable Long id, @RequestBody WebSiteServiceProvider serviceProvider) {
        return serviceProviderService.updateServiceProvider(id, serviceProvider);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id) {
        serviceProviderService.deleteServiceProvider(id);
    }

}
