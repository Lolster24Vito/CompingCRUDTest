package vitomir.hardi.compingtest.compingcrudtest.specifications;

import org.springframework.data.jpa.domain.Specification;
import vitomir.hardi.compingtest.compingcrudtest.model.WebSiteService;
import vitomir.hardi.compingtest.compingcrudtest.model.WebSiteService_;

public class WebSiteServiceSpecs {
    public static Specification<WebSiteService> likeDescriptionService(String descriptionService){
        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get(WebSiteService_.DESCRIPTION_SERVICE),"%"+descriptionService+"%");
        });
    }
    public static Specification<WebSiteService> equalId(Long id){
        return ((root, query, criteriaBuilder) ->
        {
            return criteriaBuilder.equal(root.get(WebSiteService_.ID),id);
        });
    }
}
