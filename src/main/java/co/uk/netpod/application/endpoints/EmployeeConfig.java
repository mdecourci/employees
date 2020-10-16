package co.uk.netpod.application.endpoints;

import co.uk.netpod.application.advice.LogExecutionAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EmployeeConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public LogExecutionAdvice logExecutionAdvice() {
        return new LogExecutionAdvice();
    }
}
