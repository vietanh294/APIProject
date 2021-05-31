package APIFullstack.websachcu.Service;

import APIFullstack.websachcu.Entity.CollectionEntity;
import APIFullstack.websachcu.Repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionService {

    @Autowired
    CollectionRepository collectionRepository;
    public String runUnlikeAndLikeStatus(Integer userId, Integer bookId){

        return "";
    }
}
