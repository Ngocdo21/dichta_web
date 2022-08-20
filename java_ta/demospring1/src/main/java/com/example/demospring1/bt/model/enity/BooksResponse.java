package com.example.demospring1.bt.model.enity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksResponse {
    int total;
    int pageSize;
    int pageIndex;
    private List<com.example.demospring1.bt.model.enity.Books> books;
}


