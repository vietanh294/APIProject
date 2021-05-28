package APIFullstack.websachcu.Controller;

import APIFullstack.websachcu.Controller.Request.PostBookRequest;
import APIFullstack.websachcu.Entity.BookEntity;
import APIFullstack.websachcu.Entity.CategoryEntity;
import APIFullstack.websachcu.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "bookPage")
public class PostBookController {
   @Autowired
   CategoryRepository categoryRepository;
   @GetMapping
    public String postBookPage(Model modelPostBookPage){
//       List<BookEntity> postBookForms =null;
//       PostBookRequest postBookRequests = new PostBookRequest();
//       modelPostBookPage.addAttribute("postBookForms",postBookForms);
       List<CategoryEntity> listCategory = categoryRepository.findAll();
       modelPostBookPage.addAttribute("listCategory",listCategory);
       modelPostBookPage.addAttribute("postBookRequests",new PostBookRequest());
       return "bookPage";
   }
}
