package vitomir.hardi.compingtest.compingcrudtest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vitomir.hardi.compingtest.compingcrudtest.model.WebSiteService;
import vitomir.hardi.compingtest.compingcrudtest.model.WebSiteServiceProvider;
import vitomir.hardi.compingtest.compingcrudtest.repository.WebSiteServiceProviderRepository;
import vitomir.hardi.compingtest.compingcrudtest.repository.WebSiteServiceRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class CompingCrudTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompingCrudTestApplication.class, args);
    }


    @Bean
    CommandLineRunner dataLoader(WebSiteServiceRepository serviceRepo, WebSiteServiceProviderRepository serviceProviderRepo){
        return args -> {
            /*WebSiteServiceProvider webSiteServiceProvider= new WebSiteServiceProvider()
         serviceRepo.save(new WebSiteService("dancing",))
            System.out.println("yup im here");*/
            // Create WebsiteServiceProviders
            WebSiteServiceProvider provider1 = new WebSiteServiceProvider("Provider Jack");
            WebSiteServiceProvider provider2 = new WebSiteServiceProvider("Provider Ann");
            WebSiteServiceProvider provider3 = new WebSiteServiceProvider("Provider Three");

            serviceProviderRepo.save(provider1);
            serviceProviderRepo.save(provider2);
            serviceProviderRepo.save(provider3);

            // Create WebsiteServices
            WebSiteService service1 = new WebSiteService("Service Dancing");
            WebSiteService service2 = new WebSiteService("Service of cutting grass");
            WebSiteService service3 = new WebSiteService("Service Doctor's ");

            serviceRepo.save(service1);
            serviceRepo.save(service2);
            serviceRepo.save(service3);

            // Associate WebsiteServices with WebsiteServiceProviders
            provider1.getServices().add(service1);
            provider1.getServices().add(service2);
            provider2.getServices().add(service2);
            provider3.getServices().add(service3);

            serviceProviderRepo.saveAll(Arrays.asList(provider1, provider2, provider3));
            serviceRepo.saveAll(Arrays.asList(service1, service2, service3));

            // Set reverse relationship from WebSiteService to WebSiteServiceProvider
            service1.getProviders().add(provider1);
            service2.getProviders().add(provider1);
            service2.getProviders().add(provider2);
            service3.getProviders().add(provider3);

            serviceRepo.saveAll(Arrays.asList(service1, service2, service3));

        };
    }

}
