package APIFullstack.websachcu.Controller.Response;


import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class BookForm {
//    BookEntity bookEntity =new BookEntity();
    private String title;
    private String author;
    private String picture;
    private String categoryName;
    private String publishYear;
    private String description;
    private String price;
}
