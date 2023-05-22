package ru.kpfu.itis.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.*;
import ru.kpfu.itis.converter.LocalDateConverter;
import ru.kpfu.itis.service.*;

@EnableWebMvc
@Configuration
@ComponentScan("ru.kpfu.itis.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(localDateConverter());
    }

    @Bean
    public LocalDateConverter localDateConverter(){
        return new LocalDateConverter();
    }

    @Bean
    public RecipeService recipeService() {
        return new RecipeService();
    }

    @Bean
    public UserRecipeService userRecipeService() {
        return new UserRecipeService(localDateConverter());
    }

    @Bean
    public CategoryService categoryService() {
        return new CategoryService();
    }

    @Bean
    public FavoriteRecipeService favoriteRecipeService() {
        return new FavoriteRecipeService();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Recipe API").version("v1"));
    }
}
