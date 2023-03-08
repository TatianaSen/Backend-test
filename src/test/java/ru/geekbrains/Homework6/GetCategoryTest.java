package ru.geekbrains.Homework6;

import lombok.SneakyThrows;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.geekbrains.homework5.dto.GetCategoryResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static ru.geekbrains.homework5.enums.Category.FOOD;

public class GetCategoryTest extends BaseTest {

    @SneakyThrows
    @Test
    void getCategoryByIdPositiveTest() {
        Response<GetCategoryResponse> response = categoryService.getCategory(FOOD.id).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(), equalTo(FOOD.id));
        assertThat(response.body().getTitle(), equalTo(FOOD.title));
        response.body().getProductResponses().forEach(product ->
                assertThat(product.getCategoryTitle(), equalTo(FOOD.title)));
        assertThat(categoriesMapper.selectByExample (new ru.geekbrains.homework6.db.model.CategoriesExample()).size(), equalTo(2));
    }
}
