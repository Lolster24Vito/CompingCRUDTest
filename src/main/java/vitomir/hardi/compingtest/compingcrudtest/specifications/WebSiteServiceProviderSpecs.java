package vitomir.hardi.compingtest.compingcrudtest.specifications;

import org.springframework.data.jpa.domain.Specification;
import vitomir.hardi.compingtest.compingcrudtest.model.WebSiteService;
import vitomir.hardi.compingtest.compingcrudtest.model.WebSiteServiceProvider;
import vitomir.hardi.compingtest.compingcrudtest.model.WebSiteServiceProvider_;

public class WebSiteServiceProviderSpecs {
public  static  Specification<WebSiteServiceProvider> likeName(String providerName){
    return ((root, query, criteriaBuilder) -> {
        return criteriaBuilder.like(root.get(WebSiteServiceProvider_.NAME),"%"+providerName+"%");
    });
}

}
