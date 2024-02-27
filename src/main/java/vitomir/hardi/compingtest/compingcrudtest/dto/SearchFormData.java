package vitomir.hardi.compingtest.compingcrudtest.dto;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchFormData {
    private String selectedOption;
    private String searchInput;
}
