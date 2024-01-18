# Spring seminars

## Settings
Maven project

JDK: Amazon Corretto 17 (corretto-17)

Language level: 17 (SDK default)

## Projects
___
### Seminar 1
Библиотека: spring-context

### S1Example1
Простой пример использования в main бинов (@Bean) из контейнера (@Configuration).

Варианты ручного использования бинов:
1. Аннотация @Bean для единственного экземпляра класса
2. Аннотация @Bean("name") или @Bean(name = "name") для нескольких экземпляров
3. Аннотации @Bean + @Primary для выбора приоритетного экземпляра

Аннотации:
* @Bean
* @Configuration
* @Primary

### S1Example2
Автоматическое создание бинов:
1. В классе @Configuration указываем путь к пакету с компонентами (@Component)
2. Для создания зависимости используем @Autowired

Аннотации:
* @Component
* @ComponentScan(basePackages = "org.example.domain")
* @Qualifier("nameBean") - указание нужного bean в конструкторе
* @Autowired

### S1Example3
Автоматическое создание бинов с использованием интерфейса.

Аннотации:
* @Lazy - не создает bean без необходимости (ленивая загрузка)

### S1Example4
Задание области видимости бинов, использование @Scope

Аннотации:
* @Scope(BeanDefinition.SCOPE_PROTOTYPE)

___



