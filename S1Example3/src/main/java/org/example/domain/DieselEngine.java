package org.example.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class DieselEngine {
    public DieselEngine() {
        System.out.println("Создан экземпляр DieselEngine " + this);
    }

    // @Override
    public void startEngine() {
        System.out.println("Запущен Дизель 65р.л");
    }
}
