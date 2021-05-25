package APIFullstack.websachcu.Controller;
import APIFullstack.websachcu.Controller.Request.HomeRequest;

import APIFullstack.websachcu.Entity.BookEntity;
import APIFullstack.websachcu.Entity.CategoryEntity;
import APIFullstack.websachcu.Repository.BookRepository;
import APIFullstack.websachcu.Repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping(value = "/book")
@RequestMapping(value = "/homePage")
public class HomeController {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    CategoryRepository categoryRepository;
//    @Autowired
//    BookRepository bookRepository;
    @GetMapping
    public String homePage(Model modelHomepage){
        List<BookEntity>  homeBookForms = bookRepository.findAll();
        List<CategoryEntity> cateItems = categoryRepository.findAll();
        modelHomepage.addAttribute("homeRequest",new HomeRequest());
        modelHomepage.addAttribute("homeBookForms", homeBookForms);
        modelHomepage.addAttribute("categoyItems",cateItems);
        return "homePage";
    }

    @PostMapping
    public String homePage(Model modelHomepage,
                           @ModelAttribute("homeRequest") HomeRequest homeRequest2){

        Sort sort = Sort.by(Sort.Direction.ASC,homeRequest2.getOrderBy());
        if (homeRequest2.getVector().equals("DESC")){
            sort = Sort.by(Sort.Direction.DESC,homeRequest2.getOrderBy());
        }
        PageRequest pageRequest =PageRequest.of(homeRequest2.getPageNumber(),5,sort);
        List<BookEntity>  homeBookForms = new ArrayList<>();
        if (homeRequest2.getCategoryIde() == null){
            homeBookForms = bookRepository.findAll();
        }else {
            homeBookForms = bookRepository.findAllByCategoryId(homeRequest2.getCategoryIde(),  pageRequest);
        }

        List<CategoryEntity> cateItems = categoryRepository.findAll();
        modelHomepage.addAttribute("homeRequest",homeRequest2);
        modelHomepage.addAttribute("homeBookForms", homeBookForms);
        modelHomepage.addAttribute("categoyItems",cateItems);
        return "homePage";
    }
//    @GetMapping(value ="/book" )

//    @GetMapping(value = "/{category_id}")
//    public BookListResponse getBookByCategoryId(@PathVariable(name = "category_id") Integer cateId,
//                                                @RequestParam(name = "order",defaultValue = "ASC") String order,
//                                                @RequestParam(name = "orderBy",defaultValue = "title") String orderBy){
//        return bookService.getBookByCategoryId(cateId,order,orderBy);
//    }

//    @PostMapping(value = "/addOne")
//    public BookEntity addOneBook(@RequestBody AddBookRequest addBookRequest){
//        BookEntity bookEntity = new BookEntity();
//        bookEntity.setTitle(addBookRequest.getTitle());
//        bookEntity.setAuthor(addBookRequest.getAuthor());
//        bookEntity.setCategoryId(addBookRequest.getCategoryId());
//        bookEntity= bookService.addNewBook(bookEntity);
//        return bookEntity;
//    }
//
//    @PostMapping(value = "/addList")
//    public List<BookEntity> addListBook(@RequestBody List<AddBookRequest> requests){
//        return bookService.addListBook(requests);
//    }
//
//    @PutMapping(value = "/update")
//    public BookEntity updateBook(@RequestBody UpdateBookRequest request){
//        return bookService.updateBook(request);
//    }
//
//    @DeleteMapping(value = "/delete/{id}")
//    public  String deleteBook(@PathVariable(name = "id") Integer id){
//        return bookService.deleteBook(id);
//    }
//
//    @GetMapping(value = "/native-query/{Id}")
//    public BookEntity getBookByIdNativeParam(@PathVariable(name = "Id") Integer id){
//        BookEntity entity = bookRepository.findByNameParam(id);
//        return entity;
//    }
//    @GetMapping(value = "/native-query2/{Id}")
//    public BookEntity getBookByIdNativeIndex(@PathVariable(name = "Id") Integer id){
//        BookEntity entity = bookRepository.findByNativeQuery(id);
//        return entity;
//    }
//
//    @PutMapping(value = "/update-title/{id}")
//    public  String updateNative(@PathVariable(name = "id") Integer id,
//                                @RequestParam(value = "title") String title){
//        return bookService.updateBookNative(title,id);
//    }
}

