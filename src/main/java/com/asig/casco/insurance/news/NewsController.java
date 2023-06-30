package com.asig.casco.insurance.news;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping(value = "/news")
    public ResponseEntity<?> getAllNews() {
        Optional<List<News>> newsOptional = Optional.ofNullable(newsService.getAllNews());

        if (newsOptional.isPresent()) {
            return new ResponseEntity<>(newsOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Didn't find news", HttpStatus.BAD_REQUEST);
        }
    }
}
