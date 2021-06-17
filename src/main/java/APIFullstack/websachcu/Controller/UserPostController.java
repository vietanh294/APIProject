package APIFullstack.websachcu.Controller;

import APIFullstack.websachcu.Entity.UserEntity;
import APIFullstack.websachcu.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.security.Principal;

@Controller
public class UserPostController {
    @Autowired
    UserService userService;
    @PostMapping(value = "/userPageInfo")
    public String putUserInfo(Model modelUserPageInfo, Principal principal,
                              @ModelAttribute("userPageInfoRequest") UserEntity userPageInfoRequest){
        String userName = principal.getName();
        String message = userService.putUserInfo(userName,
                userPageInfoRequest.getUserPhone(),userPageInfoRequest.getUserEmail());

        return "redirect:/login";
    }
}
