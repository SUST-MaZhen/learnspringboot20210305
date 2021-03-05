package com.learnspringboot.serviceImlp.animalImpl;

import com.learnspringboot.service.IAnimal;
import org.springframework.stereotype.Service;

@Service("animalService")
public class AnimalServiceImpl implements IAnimal {
    @Override
    public void eat() {
        System.out.println("狗爱吃肉、猫爱吃鱼");
    }

    @Override
    public void run() {
        System.out.println("狗爱跑、兔子爱跳");
    }

    @Override
    public void say() {
        System.out.println("小狗汪汪汪、小猫喵喵喵");
    }
}
