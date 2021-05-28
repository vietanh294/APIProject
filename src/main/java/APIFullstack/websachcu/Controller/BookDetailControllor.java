package APIFullstack.websachcu.Controller;

import APIFullstack.websachcu.Controller.Response.UserFormSignedIn;
import APIFullstack.websachcu.Entity.BookEntity;
import APIFullstack.websachcu.Repository.BookRepository;
import APIFullstack.websachcu.Repository.CategoryRepository;
import APIFullstack.websachcu.Service.PostBookService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/detailPage")
public class BookDetailControllor {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserFormSignedIn userFormSignedIn;
    @Autowired
    CategoryRepository categoryRepository;
//    @Autowired
//    PostBookService postBookService;
//    @PathVariable("bookid") Integer bookId
//    @GetMapping
//    public String detailPage(Model modelDetailPage){
//        UserFormSignedIn userFormSignedIn2=userFormSignedIn;
//        BookEntity bookDetail = new BookEntity();
////        BookEntity bookDetail =bookRepository.findByNativeQuery(bookId);
//        modelDetailPage.addAttribute("detailBook",bookDetail);
//        modelDetailPage.addAttribute("userFormSignedIn2",userFormSignedIn2);
//        return "detailPage";
//    }
////Getmapping co RequestParam
    @GetMapping
    public String detailPage(Model modelDetailPageAndParam,@RequestParam("id") Integer bookId){
        UserFormSignedIn userFormSignedIn3=userFormSignedIn;
        modelDetailPageAndParam.addAttribute("userFormSignedIn2",userFormSignedIn3);
//        if (bookId == null){
//            modelDetailPageAndParam.addAttribute("detailBook",new BookEntity());
//            return "detailPage";
//        }
//        BookEntity bookDetail = new BookEntity();
        BookEntity bookDetail =bookRepository.findByNativeQuery(bookId);
        modelDetailPageAndParam.addAttribute("detailBook",bookDetail);
        return "detailPage";
    }

//    @PostMapping
//    public String detailPage(Model modelDetailPageAndParam,@RequestParam("id") Integer bookId){
//        UserFormSignedIn userFormSignedIn3=userFormSignedIn;
//
////        BookEntity bookDetail = new BookEntity();
//        BookEntity bookDetail =bookRepository.findByNativeQuery(bookId);
//        modelDetailPageAndParam.addAttribute("detailBook",bookDetail);
//        modelDetailPageAndParam.addAttribute("userFormSignedIn2",userFormSignedIn3);
//        return "detailPage";
//    }

}
