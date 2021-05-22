package APIFullstack.websachcu.Entity;

import lombok.*;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;

    @Column(name = "book_name")
    private String title;

    @Column(name = "book_author")
    private String author;

    @Column(name = "book_picture")
    private  String picture;

    @Column(name = "category_id")
    private  Integer categoryId;

}
