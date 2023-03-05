package ru.geekbrains.Homework5;

import com.github.javafaker.Faker;
import ru.geekbrains.homework5.api.ProductService;
import ru.geekbrains.homework5.dto.ProductResponse;
import ru.geekbrains.homework5.utils.RetrofitUtils;
import org.junit.jupiter.api.BeforeAll;

import static ru.geekbrains.homework5.enums.Category.FOOD;

public class BaseTest {
    static ProductService productService;
    static ProductResponse product;
    static Faker faker = new Faker();
    static int id;

    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);

        product = new ProductResponse()
                .withTitle(faker.food().ingredient())
                .withCategoryTitle(FOOD.title)
                .withPrice((int) (Math.random() * 10000));
    }
}