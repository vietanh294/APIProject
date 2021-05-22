package APIFullstack.websachcu.Service;

import APIFullstack.websachcu.Controller.Request.AddBookRequest;
import APIFullstack.websachcu.Controller.Request.UpdateBookRequest;
import APIFullstack.websachcu.Controller.Response.BookListResponse;
import APIFullstack.websachcu.Entity.BookEntity;
import APIFullstack.websachcu.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public BookListResponse getBookByCategoryId(Integer cateId, String order, String orderby){
        BookListResponse response = new BookListResponse();
        List<BookEntity> data = bookRepository.findAllByCategoryId(cateId);
        response.setCode(200);
        response.setData(data);
        response.setMessage("Success");
        return response;
    }
    public BookEntity addNewBook(BookEntity bookEntity){
        return bookRepository.save(bookEntity);
    }
    public List<BookEntity> addListBook(List<AddBookRequest> requests){
        List<BookEntity> bookEntities =new ArrayList<>();
        for(AddBookRequest e : requests){
            BookEntity item =new BookEntity();
            item.setTitle(e.getTitle());
            item.setAuthor(e.getAuthor());
            item.setCategoryId(e.getCategoryId());
            bookEntities.add(item);
        }
        bookEntities = bookRepository.saveAll(bookEntities);
        return bookEntities;
    }

    public BookEntity updateBook(UpdateBookRequest request){
        BookEntity entity = bookRepository.findById(request.getId()).orElse(null);
        if (entity ==null){
            System.out.println("Not exist ID: " + request.getId());
            return null;
        }
        entity.setTitle(request.getTitle());
        entity.setAuthor(request.getAuthor());
        entity =bookRepository.save(entity);
        return entity;
    }
    public BookEntity findOneById(Integer idbook){
        return bookRepository.findById(idbook).orElse(null);
    }

    public String deleteBook(Integer id){
        BookEntity entity = bookRepository.findById(id).orElse(null);
        if (entity ==null){
            System.out.println("Not exist ID: " + id);
            return null;
        }
        bookRepository.delete(entity);
        return "OK";
    }

    @Transactional
    public String updateBookNative(String title, Integer id){
        BookEntity bookEntity =bookRepository.findById(id).orElse(null);
        if (bookEntity==null){
            System.out.println("Not exist ID: " + id);
            return  null;
        }
        bookRepository.updateBookByNativeModify(title,id);
        return "OK";
    }
}
