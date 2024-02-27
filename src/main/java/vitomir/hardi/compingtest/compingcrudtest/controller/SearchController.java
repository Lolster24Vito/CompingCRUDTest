package vitomir.hardi.compingtest.compingcrudtest.controller;

import org.springframework.web.bind.annotation.*;
import vitomir.hardi.compingtest.compingcrudtest.dto.SearchFormData;
import vitomir.hardi.compingtest.compingcrudtest.dto.SearchResponse;
import vitomir.hardi.compingtest.compingcrudtest.dto.WebSiteServiceDescriptionOnlyDTO;
import vitomir.hardi.compingtest.compingcrudtest.model.WebSiteService;
import vitomir.hardi.compingtest.compingcrudtest.model.WebSiteServiceProvider;
import vitomir.hardi.compingtest.compingcrudtest.service.WebSiteServiceProviderService;
import vitomir.hardi.compingtest.compingcrudtest.service.WebSiteServiceService;

@RestController
@RequestMapping("/api/search")
public class SearchController {
    private final WebSiteServiceProviderService serviceProviderService;
    private final WebSiteServiceService serviceService;

    public SearchController(WebSiteServiceProviderService serviceProviderService, WebSiteServiceService serviceService) {
        this.serviceProviderService = serviceProviderService;
        this.serviceService = serviceService;
    }
    @PostMapping("/")
    public SearchResponse search(@RequestBody SearchFormData searchFormData) {
        // 0=All, 1=By Description Service,2=By Provider name
        SearchResponse searchResponse=new SearchResponse();
        if(searchFormData.getSelectedOption().equals("1")||searchFormData.getSelectedOption().equals("0")) {
            Iterable<WebSiteService> byDescription = serviceService.findByDescription(searchFormData.getSearchInput());
            searchResponse.setServices(byDescription);
        }
        if(searchFormData.getSelectedOption().equals("2")||searchFormData.getSelectedOption().equals("0")) {
            Iterable<WebSiteServiceProvider> byName = serviceProviderService.findByName(searchFormData.getSearchInput());
            searchResponse.setProviders(byName);
        }
        return searchResponse;
    }
}
