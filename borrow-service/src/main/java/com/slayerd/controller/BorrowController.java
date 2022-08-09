package com.slayerd.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.slayerd.entity.UserBorrowDetail;
import com.slayerd.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

@RestController
public class BorrowController {

    @Resource
    BorrowService service;

    //A @HystrixCommand(fallbackMethod = "executeOnError")
    @RequestMapping("/borrow/{uid}")
    UserBorrowDetail findUserBorrows(@PathVariable("uid") int uid){
        return service.getUserBorrowDetailByUid(uid);
    }

    //Hystrix备选方案 A
//    UserBorrowDetail executeOnError(int uid){
//        return new UserBorrowDetail(null, Collections.emptyList());
//    }
}