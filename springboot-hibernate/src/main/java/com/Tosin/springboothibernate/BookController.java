package com.Tosin.springboothibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value={"/books"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> list() {
        return bookRepository.findAll();
    }

    @GetMapping(value={"/books/delete"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(){
        ArrayList<Long> list = new ArrayList();
        list.add(1L);
        list.add(2L);

        bookRepository.deleteAllByIdInBatch(list);

        bookRepository.findAll();
    }


//    @PostMapping(value={"/add"}, produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Book> add(){
//       ArrayList<Long, String> book = new ArrayList<>()
//    }

}
