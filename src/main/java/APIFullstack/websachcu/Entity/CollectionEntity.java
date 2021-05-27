package APIFullstack.websachcu.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Getter @Setter
@Entity
@Table(name = "user_collection")
public class CollectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_collection_id")
    private Integer colId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "user_collection_time")
    private Integer colTime;
}
