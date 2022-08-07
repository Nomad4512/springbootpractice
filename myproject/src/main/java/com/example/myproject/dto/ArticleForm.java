package com.example.myproject.dto;

import com.example.myproject.entity.Article;
import lombok.ToString;

    @ToString
    public class ArticleForm {

    private String title;
    private String content;

        public ArticleForm(String title, String content) {
            this.title = title;
            this.content = content;
        }

        public Article toEntity() {
            return new Article(null,title,content);
        }
    }
