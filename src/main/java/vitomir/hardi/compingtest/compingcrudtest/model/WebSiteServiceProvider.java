package vitomir.hardi.compingtest.compingcrudtest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WebSiteServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @JsonIgnoreProperties("providers") // Ignore this property during serialization
    @ManyToMany(mappedBy = "providers",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @ToString.Exclude
    private Set<WebSiteService> services = new HashSet<>();

// Constructors, getters, and setters

    public WebSiteServiceProvider(String name, Set<WebSiteService> services) {
        this.name = name;
        this.services = services;
    }

    public WebSiteServiceProvider(String name) {
        this.name = name;
        this.services = new HashSet<>();
    }
    // Other methods if needed

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        WebSiteServiceProvider that = (WebSiteServiceProvider) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
