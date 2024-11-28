package fr.sdis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CamionDTO {
    private String id;
    private String CentreCamionId;
    private Integer nbPompiers;
}
