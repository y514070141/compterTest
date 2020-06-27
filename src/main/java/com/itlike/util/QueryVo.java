package com.itlike.util;

import lombok.Data;

@Data
public class QueryVo {
    private int page;
    private int rows;
    private String keyword;
}
