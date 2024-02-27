package vitomir.hardi.compingtest.compingcrudtest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WebSiteService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descriptionService;
    @ManyToMany
    @JoinTable(
            name = "service_provider_services",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "provider_id"))
    @JsonIgnoreProperties("services")
    private Set<WebSiteServiceProvider> providers = new HashSet<>();

    public WebSiteService(String descriptionService, Set<WebSiteServiceProvider> providers) {
        this.descriptionService = descriptionService;
        this.providers = providers;
    }

    public WebSiteService(String descriptionService) {
        this.descriptionService = descriptionService;
        this.providers = new HashSet<>();
    }

    // Constructors, getters, and setters

    // Other methods if needed

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        WebSiteService that = (WebSiteService) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}