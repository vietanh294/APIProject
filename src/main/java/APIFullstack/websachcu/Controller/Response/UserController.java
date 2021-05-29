package APIFullstack.websachcu.Controller.Response;

import APIFullstack.websachcu.Entity.BookEntity;
import APIFullstack.websachcu.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/userPage")
public class UserController {

    @GetMapping(value = "/info")
    public String userPageInfo(Model modelUserPageInfo){
        modelUserPageInfo.addAttribute("userPageInfoRequest",new UserEntity());
        return "userPageInfo";
    }
    @GetMapping
    public String userPageInfo2(Model modelUserPageInfo2){
        return "redirect:/userPage/info";
    }
    @GetMapping(value = "/posted")
    public String userPagePosted(Model modelUserPagePosted){
        modelUserPagePosted.addAttribute("userPagePortedRequest",new BookEntity());

        return "userPagePosted";
    }
    @GetMapping(value = "/collection")
    public String userPageCollection(Model modelUserPageCollection){
        modelUserPageCollection.addAttribute("userPageCollectionRequest",new BookEntity());
        return "userPageCollection";
    }
}
