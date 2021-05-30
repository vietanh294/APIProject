package APIFullstack.websachcu.Controller.Response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserPagePostedResponse {
    private String bookTitle;
    private String publishYear;
    private String postedDate;
    private String bookPrice;
    private String bookPicture;
}
