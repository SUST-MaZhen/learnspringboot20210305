package com.learnspringboot.serviceImlp.personImpl;

import com.learnspringboot.service.IPerson;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @ClassName WomenService
 * @Author User
 * @date 2021.03.01 21:59
 */
@Service("womenService")
public class WomenServiceImpl implements IPerson {

    @Override
    public String introducePerson() {
       return "上班、下班、吃饭、睡觉打豆豆";
    };
}
