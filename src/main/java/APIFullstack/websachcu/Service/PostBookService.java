package APIFullstack.websachcu.Service;

import APIFullstack.websachcu.Controller.Response.UserFormSignedIn;
import APIFullstack.websachcu.Repository.BookRepository;
import APIFullstack.websachcu.Repository.PostBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostBookService {
    @Autowired
    PostBookRepository postBookRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserFormSignedIn userFormSignedIn;

}
