package fr.sdis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FeuDTO {
    private String id;
    private Integer coordX;
    private Integer coordY;
    private Integer intensite;
    private String IdIntervention;
}
