package com.itlike.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class pageListRes {
    private Long total;
    private List<?> rows=new ArrayList<>();
}
