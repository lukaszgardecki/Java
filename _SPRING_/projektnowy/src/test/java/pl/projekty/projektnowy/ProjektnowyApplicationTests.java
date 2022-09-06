package pl.projekty.projektnowy;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import pl.projekty.projektnowy.di.Weather;

@SpringBootTest
class ProjektnowyApplicationTests {

	@Autowired
	@Qualifier("sunny")
	Weather weather;

	@Test
	void contextLoads() {
	}

	@Test
	public void weatherInjectionTest() {
		Assert.assertFalse(weather.description.isEmpty());
	}

}
