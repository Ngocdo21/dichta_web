package com.example.demospring1.bt.repository.database;

import com.example.demospring1.bt.model.enity.BooksCategories;
import com.example.demospring1.bt.model.enity.BooksCategories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BooksDB extends JpaRepository<com.example.demospring1.bt.model.enity.Books, Integer> {

    // native query
    @Query(value = "select * from books c order by ?3 ?4 limit ?1 offset ?2", nativeQuery = true)
    List<com.example.demospring1.bt.model.enity.Books> findWithPage(int limit, int offset, String fieldSort, String sortDirection);

    @Query(value = "select count(*) from books", nativeQuery = true)
    Long countBook();

    //JPA
    @Query(value = "select c from Books c")
    Page<com.example.demospring1.bt.model.enity.Books> findWithPageJPA(Pageable pageable);

    @Query(value = "select books.id, books.name as bookName, books.price, categories.name as categoryName from books join categories where books.category_id = categories.id and books.id = ?1", nativeQuery = true)
    List<BooksCategories> findBookCategories(int id);
}
