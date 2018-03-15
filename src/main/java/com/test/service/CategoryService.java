package com.test.service;

import com.test.domain.Category;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaobin.wang
 * @date 2018/3/15
 */
public interface CategoryService {
    public List<Category> findAll();
}
