package com.example.myproject.repository;

import com.example.myproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article,Long> {

}
