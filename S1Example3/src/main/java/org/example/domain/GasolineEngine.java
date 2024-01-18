package org.example.domain;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// @Primary
public class GasolineEngine implements iEngine {
    public GasolineEngine() {
        System.out.println("Создан экземпляр GasolineEngine");
    }

    @Override
    public void startEngine() {
        System.out.println("Запущен Бензин 44р.л");
    }
}
