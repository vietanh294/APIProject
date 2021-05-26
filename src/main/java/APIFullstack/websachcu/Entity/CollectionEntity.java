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
    private Integer ucolId;
}
