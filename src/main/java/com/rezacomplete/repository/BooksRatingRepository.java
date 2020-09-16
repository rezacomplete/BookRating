package com.rezacomplete.repository;

import com.rezacomplete.model.BookRating;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BooksRatingRepository {

    public List<BookRating> findByUserId(String userId) {

        //todo should get these values from a database using the provided userId
        BookRating bookRating1 = new BookRating();
        bookRating1.setBookId("1");
        bookRating1.setRating(1.5);

        BookRating bookRating2 = new BookRating();
        bookRating2.setBookId("2");
        bookRating2.setRating(2.5);

        BookRating bookRating3 = new BookRating();
        bookRating3.setBookId("3");
        bookRating3.setRating(3.5);

        List<BookRating> bookRatings = new ArrayList<>();
        bookRatings.add(bookRating1);
        bookRatings.add(bookRating2);
        bookRatings.add(bookRating3);

        return bookRatings;
    }
}
