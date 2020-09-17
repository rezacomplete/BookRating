package com.rezacomplete.controller;

import com.rezacomplete.BookRatingApplication;
import com.rezacomplete.model.BookRating;
import com.rezacomplete.service.BooksRatingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookRatingApplication.class)
@WebAppConfiguration
public class BooksRatingResourceTest {

    private MockMvc mockMvc;

    @MockBean
    private BooksRatingService booksRatingService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void retrieveBookRatings() throws Exception {
        List<BookRating> response = new ArrayList<>();
        BookRating bookRating = new BookRating();
        bookRating.setRating(1.5);
        bookRating.setBookId("1");
        response.add(bookRating);

        when(booksRatingService.retrieveBookRatings("user1")).thenReturn(response);

        mockMvc.perform(get("/rating/user1"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"bookId\":\"1\",\"rating\":1.5}]"))
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void retrieveBookRatingsWhenNoResponse() throws Exception {
        List<BookRating> response = new ArrayList<>();

        when(booksRatingService.retrieveBookRatings("user1")).thenReturn(response);

        mockMvc.perform(get("/rating/user1"))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"))
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }


}