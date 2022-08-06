package com.reynaldo.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private String id;
    @NotNull(message = "Not have IdClient")
    @NotBlank(message = "Tiene que llenar IdClient")
    private String idClient;
    @NotNull(message = "Not have nameClient")
    @NotBlank(message = "Tiene que llenar nameClient")
    private String nameClient;
}
