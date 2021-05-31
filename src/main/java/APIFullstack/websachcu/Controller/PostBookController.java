package APIFullstack.websachcu.Controller;

import APIFullstack.websachcu.Controller.Request.PostBookRequest;

import APIFullstack.websachcu.Controller.Response.UserFormSignedIn;
import APIFullstack.websachcu.Entity.CategoryEntity;
import APIFullstack.websachcu.Repository.CategoryRepository;
import APIFullstack.websachcu.Service.PostBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "bookPage")
public class PostBookController {
   @Autowired
   CategoryRepository categoryRepository;
   @Autowired
   UserFormSignedIn userFormSignedIn;
   @Autowired
   PostBookService postBookService;
   @GetMapping
    public String getPostBookPage(Model modelPostBookPage){
//       List<BookEntity> postBookForms =null;
//       PostBookRequest postBookRequests = new PostBookRequest();
//       modelPostBookPage.addAttribute("postBookForms",postBookForms);

       List<CategoryEntity> listCategory = categoryRepository.findAll();
       modelPostBookPage.addAttribute("listCategory",listCategory);
       modelPostBookPage.addAttribute("postBookRequests",new PostBookRequest());
       String userPhone = userFormSignedIn.getUserSignedPhone();
       modelPostBookPage.addAttribute("userPhone",userPhone);
       return "bookPage";
   }
   @PostMapping
   public String postBookPage(Model modelPostBook,
                              @ModelAttribute("postBookRequests") PostBookRequest postBookRequest){
      Integer userId = userFormSignedIn.getUserSignedId();
      String runPostBookRequest = postBookService.runPostBookService(postBookRequest,userId);
      List<CategoryEntity> listCategory = categoryRepository.findAll();
      modelPostBook.addAttribute("listCategory",listCategory);
      modelPostBook.addAttribute("postBookRequests",postBookRequest);
      String userPhone = userFormSignedIn.getUserSignedPhone();
      modelPostBook.addAttribute("userPhone",userPhone);
//      if (runPostBookRequest ="bookPage"){
//         String message = "Thiếu thông tin đăng sách";
//      }
      return runPostBookRequest;
   }
}
