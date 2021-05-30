package APIFullstack.websachcu.Service;

import APIFullstack.websachcu.Controller.Response.UserPageCollectionResponse;
import APIFullstack.websachcu.Entity.BookEntity;
import APIFullstack.websachcu.Entity.CollectionEntity;
import APIFullstack.websachcu.Repository.BookRepository;
import APIFullstack.websachcu.Repository.CollectionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    CollectionRepository collectionRepository;
//    @Autowired
//    UserRepository userRepository;
    public List<UserPageCollectionResponse> getUserPageCollection(Integer userId){
        //Tim collection co userId va likestatus =1
        List<CollectionEntity> collectionList = collectionRepository.findAllByUserIdAndLikeStatus(userId,1);
        List<BookEntity> bookList =new ArrayList<>();
        List<UserPageCollectionResponse> userPageCollectionResponseList =new ArrayList<>();
        for (CollectionEntity collectionItem :
                collectionList) {
            BookEntity bookItem = bookRepository.findAllById(collectionItem.getBookId());
            UserPageCollectionResponse userPageCollectionResponseItem = new UserPageCollectionResponse();
            userPageCollectionResponseItem.setBookTitle(bookItem.getTitle());
            userPageCollectionResponseItem.setPublishYear(bookItem.getPublishYear());
            userPageCollectionResponseItem.setBookPrice(bookItem.getPrice());
            userPageCollectionResponseList.add(userPageCollectionResponseItem);
        }
//        BookEntity bookItem = bookRepository.findAllById(collectionItem.getBookId());
//        UserPageCollectionResponse userPageCollectionResponseItem = new UserPageCollectionResponse();
//        userPageCollectionResponseItem.setBookTitle(bookItem.getTitle());
//        userPageCollectionResponseItem.setPublishYear(bookItem.getPublishYear());
//        userPageCollectionResponseItem.setBookPrice(bookItem.getPrice());
        return userPageCollectionResponseList;
    }

}
