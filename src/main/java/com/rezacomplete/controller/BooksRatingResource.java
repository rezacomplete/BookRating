package com.rezacomplete.controller;

import com.rezacomplete.model.BookRating;
import com.rezacomplete.service.BooksRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksRatingResource {

    @Autowired
    private BooksRatingService booksRatingService;

    @RequestMapping(path = "/rating/{userId}", method = RequestMethod.GET)
    public List<BookRating> retrieveBookRatings(@PathVariable String userId) {

        //todo some input validations here ...
        return booksRatingService.retrieveBookRatings(userId);
    }
}
