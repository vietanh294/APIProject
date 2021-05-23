package APIFullstack.websachcu.Controller;

import APIFullstack.websachcu.Controller.Request.AddBookRequest;
import APIFullstack.websachcu.Controller.Request.UpdateBookRequest;
import APIFullstack.websachcu.Controller.Response.BookForm;
import APIFullstack.websachcu.Controller.Response.BookListResponse;
import APIFullstack.websachcu.Controller.Response.HomeBookForm;
import APIFullstack.websachcu.Entity.BookEntity;
import APIFullstack.websachcu.Entity.CategoryEntity;
import APIFullstack.websachcu.Repository.BookRepository;
import APIFullstack.websachcu.Repository.CategoryRepository;
import APIFullstack.websachcu.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping(value = "/book")
//@RequestMapping(value = "/homePage")
public class HomeController {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    CategoryRepository categoryRepository;
//    @Autowired
//    BookRepository bookRepository;
    @GetMapping(value ="/homePage" )
    public String homePage(Model modelHomepage){
        List<BookEntity>  homeBookForms = bookRepository.findAll();
        List<CategoryEntity> cateItems = categoryRepository.findAll();
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

