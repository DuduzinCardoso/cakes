package com.cake.dto.cake;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCakeDto {
    private Long cakeId;
    private String cakeName;
    private String cakeDescription;
    private LocalDate cakeCreatedDate;
    private String cakeURL;
}

