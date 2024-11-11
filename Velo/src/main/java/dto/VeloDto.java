package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeloDto {
    private long id;
    private String type;
    private String marque;
    private boolean status;
}