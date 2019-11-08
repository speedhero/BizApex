package com.apex.controller;

import com.apex.bussiness.entity.Product;
import com.apex.bussiness.framework.VO.ResponseVO;
import com.apex.bussiness.service.interfaces.ITstProductService;
import com.apex.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class IndexController {


    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index(){
        return "index";
    }


    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "love";
    }


    @Autowired
    private ITstProductService tstProductService;


    //jwt登录方式    @PostMapping 找不到对应handler
    @RequestMapping("/Products")
    @ResponseBody
    public ResponseVO login(HttpServletRequest request, HttpServletResponse response) {
        ResponseVO responseVO= ResultUtil.success("登录成功！");
        List<Product> products= tstProductService.listTstProduct();
        responseVO.setData(products);
        return  responseVO;
    }
}
