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
        List<CollectionEntity> collectionList = collectionRepository.findAllByUserId(userId);
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
