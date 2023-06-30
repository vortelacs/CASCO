package com.asig.casco.insurance.news;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    public List<News> getAllNews(){
        return newsRepository.findAll();
    }

}
