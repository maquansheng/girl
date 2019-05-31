package com.ma.controller;

import com.ma.domain.Girl;
import com.ma.domain.Result;
import com.ma.reponstitory.GirlReponstitory;
import com.ma.service.GirlService;
import com.ma.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlReponstitory girlReponstitory;
    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/save")
    public Object add(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.print(bindingResult.getFieldError().getDefaultMessage());
            return bindingResult.getFieldError().getDefaultMessage();
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return girlReponstitory.save(girl);
    }

    @GetMapping(value = "/save2")
    public Object add2(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Result result = new Result();
            result.setCode(0);
            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            result.setData(null);
            return result;
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        Result result = new Result();
        result.setCode(1);
        result.setData(girlReponstitory.save(girl));
        result.setMsg("成功");
        return result;
    }

    @GetMapping(value = "/save3")
    public Object add3(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(0, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlReponstitory.save(girl));
    }

    @RequestMapping("/list")
    public List<Girl> list() {
        return girlReponstitory.findAll();
    }

    /*
    异常处理案例
     */
    @RequestMapping("/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge2(id);
    }
}
