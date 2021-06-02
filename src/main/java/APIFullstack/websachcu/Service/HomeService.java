package APIFullstack.websachcu.Service;

import APIFullstack.websachcu.Controller.Request.HomeRequest;
import APIFullstack.websachcu.Entity.BookEntity;
import APIFullstack.websachcu.Repository.BookRepository;
import APIFullstack.websachcu.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<BookEntity> runHomeService(HomeRequest homeRequest){
        Sort sort = Sort.by(Sort.Direction.ASC,homeRequest.getOrderBy());
        if (homeRequest.getDirection().equals("DESC")){
            sort = Sort.by(Sort.Direction.DESC,homeRequest.getOrderBy());
        }
        PageRequest pageRequest =PageRequest.of(homeRequest.getPageNumber(),8,sort);
        List<BookEntity>  homeBookForms = new ArrayList<>();
        if (homeRequest.getCategoryIde() == null){
            homeBookForms = bookRepository.findAll();
        }else {
            homeBookForms = bookRepository.findAllByCategoryId(homeRequest.getCategoryIde(),  pageRequest);
        }
        return homeBookForms;
    }
//    public HashMap<String,String> mapOrderByHomePage{
//        return new HashMap<String,String>();
//    }


}
