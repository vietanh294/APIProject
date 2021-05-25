//package APIFullstack.websachcu.Service;
//
//import APIFullstack.websachcu.Controller.Request.HomeRequest;
//import APIFullstack.websachcu.Entity.BookEntity;
//import APIFullstack.websachcu.Entity.CategoryEntity;
//import APIFullstack.websachcu.Repository.BookRepository;
//import APIFullstack.websachcu.Repository.CategoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class HomeService {
//
//    @Autowired
//    BookRepository bookRepository;
//    @Autowired
//    CategoryRepository categoryRepository;
//
//
//    public void getBookByCategoryId(HomeRequest homeRequest){
//
//
//        List<BookEntity> homeBookForms = new ArrayList<>();
//            if (homeRequest.getCategoryIde() == null){
//             homeBookForms = bookRepository.findAll();
//            }else {
//            homeBookForms = bookRepository.findAllByCategoryId(homeRequest.getCategoryIde());
//            }
//
//        List<CategoryEntity> cateItems = categoryRepository.findAll();
//        return;
//
//
//    }
//}
