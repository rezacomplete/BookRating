package com.rezacomplete.service;

import com.rezacomplete.model.BookRating;
import com.rezacomplete.repository.BooksRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksRatingServiceImpl implements BooksRatingService {

    @Autowired
    private BooksRatingRepository booksRatingRepository;

    @Override
    public List<BookRating> retrieveBookRatings(String userId) {
        return booksRatingRepository.findByUserId(userId);
    }
}
