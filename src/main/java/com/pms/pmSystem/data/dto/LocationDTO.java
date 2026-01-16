package com.pms.pmSystem.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTO {

    private String ipAddress;
    private String device;
    private String os;
    private String routeName;
    private String browser;
}
