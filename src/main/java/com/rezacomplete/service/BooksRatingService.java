package com.rezacomplete.service;

import com.rezacomplete.model.BookRating;

import java.util.List;

public interface BooksRatingService {
    List<BookRating> retrieveBookRatings(String userId);
}
