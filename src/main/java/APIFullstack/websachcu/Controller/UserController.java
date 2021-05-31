package APIFullstack.websachcu.Controller;

import APIFullstack.websachcu.Controller.Response.UserFormSignedIn;
import APIFullstack.websachcu.Controller.Response.UserPageCollectionResponse;
import APIFullstack.websachcu.Entity.BookEntity;
import APIFullstack.websachcu.Entity.CollectionEntity;
import APIFullstack.websachcu.Entity.UserEntity;
import APIFullstack.websachcu.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/userPage")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserFormSignedIn userFormSignedIn;

    @GetMapping(value = "/info")
    public String userPageInfo(Model modelUserPageInfo){
        modelUserPageInfo.addAttribute("userPageInfoRequest",new UserEntity());
        String userPhone =userFormSignedIn.getUserSignedPhone();
        modelUserPageInfo.addAttribute("userPhone",userPhone);
        return "userPageInfo";
    }
    @GetMapping
    public String userPageInfo2(Model modelUserPageInfo2){
        return "redirect:/userPage/info";
    }
    @GetMapping(value = "/posted")
    public String userPagePosted(Model modelUserPagePosted){
        modelUserPagePosted.addAttribute("userPagePortedRequest",new BookEntity());
        String userPhone =userFormSignedIn.getUserSignedPhone();
        modelUserPagePosted.addAttribute("userPhone",userPhone);
        return "userPagePosted";
    }
    @GetMapping(value = "/collection")
    public String userPageCollection(Model modelUserPageCollection){
        Integer userId = userFormSignedIn.getUserSignedId();
        String userPhone =userFormSignedIn.getUserSignedPhone();
        List<UserPageCollectionResponse> userPageCollectionResponseList = userService.getUserPageCollection(userId);
        modelUserPageCollection.addAttribute("userPageCollectionRequest",new CollectionEntity());
        modelUserPageCollection.addAttribute("userPageCollectionResponseList",userPageCollectionResponseList);
        modelUserPageCollection.addAttribute("userPhone",userPhone);
        return "userPageCollection";
    }
    @PutMapping(value = "/collection")
    public String userUnlikeBookCollection(Model modelUserUnlikeBookCollection,
                                           @ModelAttribute("userPageCollectionRequest")CollectionEntity collectionEntity,
                                           @ModelAttribute("userPageCollectionResponseList")List<UserPageCollectionResponse> userPageCollectionResponseList,
                                           @ModelAttribute("userPhone")String userPhone){

        modelUserUnlikeBookCollection.addAttribute("userPageCollectionRequest",new CollectionEntity());
        modelUserUnlikeBookCollection.addAttribute("userPageCollectionResponseList",userPageCollectionResponseList);
        modelUserUnlikeBookCollection.addAttribute("userPhone",userPhone);
        return "userPageCollection";
    }
}
