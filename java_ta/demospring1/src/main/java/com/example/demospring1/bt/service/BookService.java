package com.example.demospring1.bt.service;

import com.example.demospring1.bt.model.enity.BooksCategories;
import com.example.demospring1.bt.model.enity.BooksResponse;
import com.example.demospring1.bt.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<com.example.demospring1.bt.model.enity.Books> findAllBooks() {
        return bookRepository.findAllBooks();
    }

    public BooksResponse findWithPage(int pageIndex, int pageSize, String fieldSort, String sortDirection) {
        return bookRepository.findWithPage(pageSize, pageIndex, fieldSort, sortDirection);
    }

    public BooksResponse findWithPageJPA(int pageIndex, int pageSize, String fieldSort, String sortDirection) {
        return bookRepository.findWithPageJPA(pageSize, pageIndex - 1, fieldSort, sortDirection);
    }

    public List<BooksCategories> findBookCategories(int id) {
        return bookRepository.findBookCategories(id);
    }
}

