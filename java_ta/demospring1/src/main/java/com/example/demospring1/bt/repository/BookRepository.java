package com.example.demospring1.bt.repository;

import com.example.demospring1.bt.model.enity.BooksCategories;
import com.example.demospring1.bt.model.enity.BooksResponse;
import com.example.demospring1.bt.repository.database.BooksDB;
import com.example.demospring1.bt.repository.database.CategoriesDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class BookRepository {
    @Autowired
    BooksDB booksDB;
    @Autowired
    CategoriesDB categoriesDB;

    public List<com.example.demospring1.bt.model.enity.Books> findAllBooks() {
        return booksDB.findAll();
    }

    public BooksResponse findWithPage(
            int pageSize, int pageIndex, String fieldSort, String sortDirection) {
        List<com.example.demospring1.bt.model.enity.Books> list = booksDB.findWithPage(pageSize, (pageIndex - 1) * pageSize, fieldSort, sortDirection);
        long totalRecord = booksDB.countBook();
        int totalPage = (int) (totalRecord / pageSize);
        if (totalRecord % pageSize > 0) {
            totalPage++;
        }
        return BooksResponse.builder()
                .total(totalPage)
                .pageIndex(pageIndex)
                .pageSize(pageSize)
                .books(list)
                .build();
    }

    public BooksResponse findWithPageJPA(
            int pageSize, int pageIndex, String fieldSort, String sortDirection) {
        Sort.Direction direction = Sort.Direction.DESC;
        if ("asc".equals(sortDirection)) {
            direction = Sort.Direction.ASC;
        }
        Pageable pageable = PageRequest.of(pageIndex, pageSize).withSort(Sort.by(direction, fieldSort));
        Page<com.example.demospring1.bt.model.enity.Books> page = booksDB.findWithPageJPA(pageable);
        return BooksResponse.builder()
                .total(page.getTotalPages())
                .pageIndex(pageIndex + 1)
                .pageSize(pageSize)
                .books(page.getContent())
                .build();
    }

    public List<BooksCategories> findBookCategories(int id) {
        return booksDB.findBookCategories(id);
    }
}

