import com.github.robby300.weather.WeatherApp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Unit-level testing for {@link WeatherApp} object.
 */
@SpringBootTest
public class WeatherAppTest {

    @Test
    public void shouldCreateJavaRepositoryTemplateMain() {
        WeatherApp main = new WeatherApp();
        Assertions.assertNotNull(main);
    }

}
