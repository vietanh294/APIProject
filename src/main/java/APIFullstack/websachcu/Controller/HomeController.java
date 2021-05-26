package APIFullstack.websachcu.Controller;
import APIFullstack.websachcu.Controller.Request.HomeRequest;

import APIFullstack.websachcu.Controller.Response.UserFormSignedIn;
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
    @Autowired
    UserFormSignedIn userFormSignedIn;
//    @Autowired
//    BookRepository bookRepository;
    @GetMapping
    public String homePage(Model modelHomepage){
        List<BookEntity>  homeBookForms = bookRepository.findAll();
        List<CategoryEntity> cateItems = categoryRepository.findAll();
        UserFormSignedIn userFormSignedIn1=userFormSignedIn;
        modelHomepage.addAttribute("homeRequest",new HomeRequest());
        modelHomepage.addAttribute("homeBookForms", homeBookForms);
        modelHomepage.addAttribute("categoyItems",cateItems);
        modelHomepage.addAttribute("userFormSignedIn1",userFormSignedIn1);
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
        UserFormSignedIn userFormSignedIn2=userFormSignedIn;
        modelHomepage.addAttribute("homeRequest",homeRequest2);
        modelHomepage.addAttribute("homeBookForms", homeBookForms);
        modelHomepage.addAttribute("categoyItems",cateItems);
        modelHomepage.addAttribute("userFormSignedIn1",userFormSignedIn2);
        return "homePage";
    }
}

