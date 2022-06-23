package com.slayerd.service.impl;

import com.slayerd.entity.Book;
import com.slayerd.mapper.BookMapper;
import com.slayerd.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book getBookById(int bid) {
        return bookMapper.getBookById(bid);
    }
}
