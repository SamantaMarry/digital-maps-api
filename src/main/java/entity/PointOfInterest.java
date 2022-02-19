package entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class PointOfInterest {

    @Id
    private String id;
    private String name;
    private LocalTime opened;
    private LocalTime closed;
    private Localization localization;

}
