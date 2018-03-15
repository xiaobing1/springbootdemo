package com.test.service.impl;

import com.test.domain.Category;
import com.test.domain.CategoryExample;
import com.test.mapper.CategoryMapper;
import com.test.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaobin.wang
 * @date 2018/3/15
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> findAll() {
        return categoryMapper.selectByExample(new CategoryExample());
    }
}
