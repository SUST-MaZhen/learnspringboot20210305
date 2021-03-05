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

    }

    @Override
    public void say() {

    }
}
