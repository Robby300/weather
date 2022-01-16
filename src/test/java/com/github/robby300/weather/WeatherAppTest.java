package com.github.robby300.weather;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit-level testing for {@link WeatherApp} object.
 */
public class WeatherAppTest {

    @Test
    public void shouldCreateJavaRepositoryTemplateMain() {
        WeatherApp main = new WeatherApp();
        Assertions.assertNotNull(main);
    }

}
