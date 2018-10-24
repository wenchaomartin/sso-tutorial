package me.ssoresource;

import me.ssoresource.utils.JwtFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class SsoResourceApplication {

	@Value("${auth.server}")
	protected String authServer;

	public static void main(String[] args) {
		SpringApplication.run(SsoResourceApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.setInitParameters(Collections.singletonMap("authServer", authServer));
		registrationBean.addUrlPatterns("/protect-resource");
		return registrationBean;
	}
}
