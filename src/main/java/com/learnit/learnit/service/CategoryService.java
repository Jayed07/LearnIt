package com.learnit.learnit.service;

import java.util.Map;

public interface CategoryService {

    void seedCategories();

    Map<String, String> getAllCategories();

}
