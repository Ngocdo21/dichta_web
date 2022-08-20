package com.example.demospring1.bt.model.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse <T>{
    private int code;
    private String message;
    private T data;
}
