package com.ma.service;

import com.ma.domain.Girl;
import com.ma.enums.ResultEnum2;
import com.ma.exception.GirlException;
import com.ma.reponstitory.GirlReponstitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GirlService {
    @Autowired
    private GirlReponstitory girlReponstitory;

    /*
    异常处理
     */

    //不用枚举
//    public void getAge(Integer id) throws Exception
//    {
//       Girl girl= girlReponstitory.findById(id).get();
//       if (girl.getAge()<=10){
//            throw new GirlException(100,"小学生");
//       }else if(girl.getAge()>10 && girl.getAge()<16){
//            throw new GirlException(101,"da学生");
//       }
//
//    }

    //使用枚举
    public void getAge2(Integer id) throws Exception {
        Girl girl = girlReponstitory.findById(id).get();
        if (girl.getAge() <= 10) {
            throw new GirlException(ResultEnum2.PRIMARY_SCHOOL);
        } else if (girl.getAge() > 10 && girl.getAge() < 16) {
            throw new GirlException(ResultEnum2.MIDDLE_SCH);
        }

    }
}
