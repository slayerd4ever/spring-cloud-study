package com.slayerd.service.impl;

import com.slayerd.Client.BookClient;
import com.slayerd.Client.UserClient;
import com.slayerd.entity.Book;
import com.slayerd.entity.Borrow;
import com.slayerd.entity.User;
import com.slayerd.entity.UserBorrowDetail;
import com.slayerd.mapper.BorrowMapper;
import com.slayerd.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Resource
    BorrowMapper mapper;

    @Autowired
    UserClient userClient;

    @Autowired
    BookClient bookClient;
    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrow = mapper.getBorrowsByUid(uid);
        //这里通过调用getForObject来请求其他服务，并将结果自动进行封装
        //获取User信息
        User user = userClient.findUserById(uid);
        //获取每一本书的详细信息
        List<Book> bookList = borrow
                .stream()
                .map(b -> bookClient.findBookById(b.getBid()))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user, bookList);
    }
}
