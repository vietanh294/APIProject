package APIFullstack.websachcu.Repository;

import APIFullstack.websachcu.Entity.BookEntity;
import APIFullstack.websachcu.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Integer> {

    List<BookEntity> findAllByCategoryId(Integer cateId);
    List<BookEntity> findAllByAuthor(String author);
    List<BookEntity> findAllByCategoryIdAndAuthor(Integer cateId, String author);

//    List<CategoryEntity> findAll();

    @Query(nativeQuery = true, value = "SELECT * FROM book WHERE book_id =:IdB")
    BookEntity findByNameParam(@Param("IdB") Integer id);

    @Query(nativeQuery = true, value = "SELECT * FROM book WHERE book_id =?1 ")
    BookEntity findByNativeQuery(Integer id);


    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE book SET book_name = ?1 WHERE book_id = ?2 ")
    int updateBookByNativeModify(String title, Integer id);
}