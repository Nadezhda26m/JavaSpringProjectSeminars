package org.example;

import org.example.config.ProjectConfig;
import org.example.domain.Car;
import org.example.domain.DieselEngine;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Car p = context.getBean(Car.class);
        p.go();
        System.out.println("----------------------");

        DieselEngine dEng = context.getBean(DieselEngine.class);
        System.out.println(dEng);
    }
}
/*
- без @Lazy
Создан экземпляр GasolineEngine
Автомобиль создан!
Создан экземпляр DieselEngine org.example.domain.DieselEngine@a514af7
Запущен Бензин 44р.л
----------------------
org.example.domain.DieselEngine@a514af7

- с @Lazy
Создан экземпляр GasolineEngine
Автомобиль создан!
Запущен Бензин 44р.л
----------------------
Создан экземпляр DieselEngine
 */