package vitomir.hardi.compingtest.compingcrudtest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vitomir.hardi.compingtest.compingcrudtest.model.WebSiteService;
import vitomir.hardi.compingtest.compingcrudtest.model.WebSiteServiceProvider;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResponse {
    private Iterable<WebSiteService> services;
    private Iterable<WebSiteServiceProviderDTO> providers;

}
