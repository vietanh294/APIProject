package APIFullstack.websachcu.Repository;

import APIFullstack.websachcu.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
    List<CategoryEntity> findAllByCateId(Integer cateId);
//    List<CategoryEntity> findAllByCateId(Integer cateId);

}
