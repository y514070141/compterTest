package com.itlike.util;

import lombok.Data;

@Data
public class QueryVo {
    private int pages;
    private int rows;
    private String keyword;
}
