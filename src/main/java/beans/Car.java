package beans;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@RequiredArgsConstructor
public class Car {
    private int id;
    @NonNull
    private String brand;
}
