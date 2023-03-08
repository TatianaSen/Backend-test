package ru.geekbrains.Homework6;

import com.github.javafaker.Faker;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.geekbrains.homework5.api.CategoryService;
import ru.geekbrains.homework5.api.ProductService;
import ru.geekbrains.homework5.dto.ProductResponse;
import ru.geekbrains.homework5.utils.RetrofitUtils;

import java.io.IOException;
import java.io.InputStream;

import static ru.geekbrains.homework5.enums.Category.FOOD;

abstract class BaseTest {
    static CategoryService categoryService;
    static ProductService productService;
    static ProductResponse product;
    static Faker faker = new Faker();
    static int id;
    static String resource = "mybatis-config.xml";
    static SqlSession session = null;
    static ru.geekbrains.homework6.db.dao.ProductsMapper productsMapper;
    static ru.geekbrains.homework6.db.dao.CategoriesMapper categoriesMapper;

    @BeforeAll
    static void beforeAll() throws IOException {
        categoryService = RetrofitUtils.getRetrofit().create(CategoryService.class);
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);

        product = new ProductResponse()
                .withTitle(faker.food().ingredient())
                .withCategoryTitle(FOOD.title)
                .withPrice((int) (Math.random() * 10000));

        categoriesMapper = getCategoriesMapper(resource);
        productsMapper = getProductsMapper(resource);
    }

    private static SqlSession getSqlSession(String resource) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        return session;
    }

    public static ru.geekbrains.homework6.db.dao.ProductsMapper getProductsMapper(String resource) throws IOException {
        session = getSqlSession(resource);
        return session.getMapper(ru.geekbrains.homework6.db.dao.ProductsMapper.class);
    }

    public static ru.geekbrains.homework6.db.dao.CategoriesMapper getCategoriesMapper(String resource) throws IOException {
        session = getSqlSession(resource);
        return session.getMapper (ru.geekbrains.homework6.db.dao.CategoriesMapper.class);
    }

    @AfterAll
    static void afterTest() {
        session.close();
    }
}