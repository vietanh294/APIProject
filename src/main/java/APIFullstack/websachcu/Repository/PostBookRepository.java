package APIFullstack.websachcu.Repository;

import APIFullstack.websachcu.Entity.PostedBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostBookRepository extends JpaRepository<PostedBookEntity,Integer> {
    PostedBookEntity findAllByBookId(Integer bookId);
}
