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

* `@Bean`
* `@Configuration`
* `@Primary`

### S1Example2

Автоматическое создание бинов:

1. В классе @Configuration указываем путь к пакету с компонентами (@Component)
2. Для создания зависимости используем @Autowired

Аннотации:

* `@Component`
* `@ComponentScan(basePackages = "org.example.domain")`
* `@Qualifier("nameBean") - указание нужного bean в конструкторе`
* `@Autowired`

### S1Example3

Автоматическое создание бинов с использованием интерфейса.

Аннотации:

* `@Lazy` - не создает bean без необходимости (ленивая загрузка)

### S1Example4

Задание области видимости бинов, использование @Scope

Аннотации:

* `@Scope(BeanDefinition.SCOPE_PROTOTYPE)`

___

### Seminar 2

[spring initializr](https://start.spring.io/)

### S2Example1

Зависимости: Spring Web

Создание простого контроллера.

Аннотации:

* `@Controller`
* `@RequestMapping("/path")`

### S2Example2

Зависимости: Spring Web

Создание простого REST контроллера.

Аннотации:

* `@RestController`
* `@GetMapping("/path")`

### S2Example3

Зависимости: Spring Web и Thymeleaf

Использование @Scope (+ @Component). Программа запрашивает пароль и считает количество
регистраций пользователя.

username: natalie
password: password

Аннотации:

* `@Service`
* `@RequestParam`
* `@RequestParam(required = false) String logout`
* `@PostMapping("/path")`
* `@RequestScope`
* `@SessionScope`
* `@ApplicationScope`

___

### Seminar 3

[spring initializr](https://start.spring.io/)

### S3Example1

Зависимости: Spring Web

Простой пример использования контроллера и статичной html-страницы.

http://localhost:8080/about

### S3Example2

Зависимости: Spring Web и Thymeleaf

Создание простой веб-страницы с выводом рандомного числа (использование простого шаблона).

Получение данных от клиента (min, max) через путь различными способами.

1. Переход по запросу и вывод рандомного числа без использования параметров

   http://localhost:8080/random

2. Передача параметров через путь (@PathVariable)

   http://localhost:8080/random/20/28

3. Передача параметров через параметры HTTP-запроса (@RequestParam)

   http://localhost:8080/new-random?min=1&max=45

4. Использование параметров из application.properties (@Value)

   http://localhost:8080/new-random/15/12345

Аннотации:

* `@PathVariable("min")`
* `@RequestParam("min")`
* `@Value("${data.random.param.min:25}")`

### S3Example3

Зависимости:

* Spring Web
* Thymeleaf
* Lombok

Вывод таблицы со списком продуктов с помощью шаблонизатора.
Передача данных в контроллер через форму на странице.

http://localhost:8080/products

Аннотации:

* `@Data` (Lombok)
* `@AllArgsConstructor` (Lombok)

---

### Seminar 4

[spring initializr](https://start.spring.io/)

### S4Example1

Зависимости:

* Spring Web
* H2 Database
* Spring Data JDBC
* Lombok

Приложение для работы с аккаунтами и перевода денег между ними.

1. (GET) Получение списка всех аккаунтов

   http://localhost:8080/accounts

2. (GET) Получение определенного аккаунта по имени

   http://localhost:8080/accounts?name=Jane%20Down

3. (POST) Перевод средств (транзакция)

   http://localhost:8080/transfer

         {
         "senderAccountId": 1,
         "receiverAccountId": 2,
         "amount": 100
         }

Аннотации:

* `@Id`
* `@Query("SELECT ...")`
* `@Modifying`
* `@Transactional`
* `@RequestParam(required = false)`

### S4Example2

Зависимости:

* Spring Web
* H2 Database
* Spring Data JPA
* Lombok

Приложение для работы с книгами и БД.

Получение списка всех книг - http://localhost:8080/books

Аннотации:

* `@Entity`
* `@Table(name = "name")`
* `@GeneratedValue(strategy = GenerationType.IDENTITY)`
* `@Column(name = "name", nullable = false)`
* `@Repository`

### S4Example3

Зависимости:

* Spring Web
* H2 Database
* Spring Data JPA
* Lombok

Приложение для работы со студентами и курсами. Сущности студента и курса связаны
между собой в БД по связи ManyToMany.

* (POST) http://localhost:8080/students - добавление студента

      {
       "name": "Студент1"
      }

* (POST) http://localhost:8080/courses - добавление курса

      {
       "title": "Курс 1"
      }

* (GET) http://localhost:8080/students - получение списка студентов

* (GET) http://localhost:8080/courses - получение списка курсов
* (POST) http://localhost:8080/students/1/courses/1 - запись студента с id=1 на курс с id=1

Аннотации:

* `@ManyToMany(mappedBy = "courses")`
* `@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)`
* `@JoinTable(name = "student_courses",
  joinColumns = @JoinColumn(name = "student_id"),
  inverseJoinColumns = @JoinColumn(name = "course_id"))`

[DOCS: Package jakarta.persistence (Jakarta EE Platform API v9.0.0)](https://jakarta.ee/specifications/platform/9/apidocs/jakarta/persistence/package-summary)

---
