package APIFullstack.websachcu.Controller.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HomeRequest {
    private Integer categoryIde;
    private String orderBy;
    private String vector;
}
