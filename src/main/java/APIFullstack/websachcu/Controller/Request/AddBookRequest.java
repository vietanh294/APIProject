package APIFullstack.websachcu.Controller.Request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddBookRequest {
    private String title;
    private String author;
//    private String avatar;
    private Integer categoryId;
}
