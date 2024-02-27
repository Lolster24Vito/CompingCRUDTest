package vitomir.hardi.compingtest.compingcrudtest.controller;

import org.springframework.web.bind.annotation.*;
import vitomir.hardi.compingtest.compingcrudtest.dto.WebSiteServiceDescriptionOnlyDTO;
import vitomir.hardi.compingtest.compingcrudtest.model.WebSiteService;
import vitomir.hardi.compingtest.compingcrudtest.service.WebSiteServiceService;

import java.util.Optional;

@RestController
@RequestMapping("/api/services")
public class ServiceController {


    private final WebSiteServiceService serviceService;

    public ServiceController(WebSiteServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/")
    public Iterable<WebSiteServiceDescriptionOnlyDTO> getAllServices() {
        return serviceService.getAllServices();
    }

    @GetMapping("/{id}")
    public Optional<WebSiteService> getServiceById(@PathVariable Long id) {
        return serviceService.getServiceById(id);
    }

    @PostMapping("/")
    public WebSiteService createService(@RequestBody WebSiteService service) {
        return serviceService.createService(service);
    }

    @PutMapping("/{id}")
    public WebSiteService updateService(@PathVariable Long id, @RequestBody WebSiteService service) {
        return serviceService.updateService(id, service);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id) {
       // Iterable<WebSiteService> da = serviceService.findByDescription("Service");

        serviceService.deleteService(id);
    }
}


   /* @GetMapping("/services/filter")
    public Flux<WebSiteService> getFilteredServices(@RequestParam Map<String, String> searchParams) {
        // Implement filtering logic based on searchParams
        // For example, use a service method that applies filters to the data

        // Implement filtering logic based on searchParams
        // Use a repository method or other logic to filter services
        // Example: return serviceRepository.findByDescriptionAndProviders(searchParams.get("description"), searchParams.get("provider"));
/*
@GetMapping("/services/filter")
public List<Service> getFilteredServices(@RequestParam Map<String, String> searchParams) {
    // Iterate over the map and apply filters as needed
    String descriptionFilter = searchParams.get("description");
    String providerFilter = searchParams.get("provider");

    // Apply filters using your service or repository methods
    return serviceService.getFilteredServices(descriptionFilter, providerFilter);
}
 */
/*
        return serviceService.getFilteredServices(searchParams);
    }
}
*/


/*

@RestController
@RequestMapping("/api")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/services")
    public List<Service> getAllServices() {
        return serviceService.getAllServices();
    }

    // Add methods for create, update, delete, etc.
}
 */