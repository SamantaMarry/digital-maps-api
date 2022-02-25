package com.digitalmaps.api.response;

import com.digitalmaps.api.enums.PointStatusEnum;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointOfInterestNearResponse {
    private String name;
    private PointStatusEnum status;

}
