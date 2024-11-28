package fr.sdis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CaserneDTO {
    private String id;
    private Integer coordX;
    private Integer coordY;
    private Integer nbPompiers;
}
