package config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import controller.TestController;

@Configurable
public class ControllerConfig {

	@Bean
	public TestController testController() {
		TestController testController = new TestController();
		return testController;
	}
	
}
