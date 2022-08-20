package com.example.demospring1.bt.controller;

import com.example.demospring1.bt.model.base.BaseResponse;
import com.example.demospring1.bt.model.enity.BooksCategories;
import com.example.demospring1.bt.model.enity.BooksResponse;
import com.example.demospring1.bt.service.BookService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "mysql")

public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("/books")
    public ResponseEntity<BaseResponse<BooksResponse>> findAllBooks() {
        BaseResponse<BooksResponse> baseResponse = new BaseResponse<>();
        List<com.example.demospring1.bt.model.enity.Books> books = bookService.findAllBooks();

        BooksResponse booksResponse = BooksResponse.builder().books(books).build();

        baseResponse.setCode(1);
        baseResponse.setMessage("success");
        baseResponse.setData(booksResponse);

        return ResponseEntity.ok(baseResponse);
    }

    @RequestMapping("/books-with-page")
    public ResponseEntity<BaseResponse<BooksResponse>> findWithPage(
            @RequestParam("pageIndex") int pageIndex,
            @RequestParam("pageSize") int pageSize,
            @RequestParam(value = "fieldSort") String fieldSort,
            @RequestParam(value = "sortDirection") String sortDirection
    ) {
        BaseResponse<BooksResponse> baseResponse = new BaseResponse<>();
        BooksResponse booksResponse = bookService.findWithPage(pageIndex, pageSize, fieldSort, sortDirection);
        baseResponse.setCode(1);
        baseResponse.setMessage("success");
        baseResponse.setData(booksResponse);

        return ResponseEntity.ok(baseResponse);
    }

    @RequestMapping("/books-with-page-jpa")
    public ResponseEntity<BaseResponse<BooksResponse>> findWithPageJPA(
            @RequestParam("pageIndex") int pageIndex,
            @RequestParam("pageSize") int pageSize,
            @RequestParam(value = "fieldSort") String fieldSort,
            @RequestParam(value = "sortDirection") String sortDirection
    ) {
        BaseResponse<BooksResponse> baseResponse = new BaseResponse<>();
        BooksResponse booksResponse = bookService.findWithPageJPA(pageIndex, pageSize, fieldSort, sortDirection);
        baseResponse.setCode(1);
        baseResponse.setMessage("success");
        baseResponse.setData(booksResponse);

        return ResponseEntity.ok(baseResponse);
    }

    @RequestMapping("/books-categories/{id}")
    public ResponseEntity<BaseResponse<List<BooksCategories>>> findBookCategories(
            @PathVariable("id") int id) {
        BaseResponse<List<BooksCategories>> baseResponse = new BaseResponse<>();
        List<BooksCategories> list= bookService.findBookCategories(id);
        baseResponse.setCode(1);
        baseResponse.setMessage("success");
        baseResponse.setData(list);

        return ResponseEntity.ok(baseResponse);
    }

}
