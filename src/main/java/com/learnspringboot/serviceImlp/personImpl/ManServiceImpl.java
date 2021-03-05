package com.learnspringboot.serviceImlp.personImpl;

import com.learnspringboot.service.IPerson;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @ClassName ManServiceImpl
 * @Author User
 * @date 2021.03.01 22:02
 */
@Service("manService")
public class ManServiceImpl implements IPerson {
    @Override
    public String introducePerson() {
        return "豆豆";
    }
}
