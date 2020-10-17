package co.uk.netpod.application.endpoints;


import co.uk.netpod.application.advice.LogExecutionTime;
import co.uk.netpod.application.model.Employee;
import co.uk.netpod.application.model.MarketDate;
import co.uk.netpod.application.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

//@Component
//@ConfigurationProperties
@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {
    @Value("${application.customer}")
    private String message;

    @Value("${application.appname}")
    private String appname;

    @Value("${application.market.url}")
    private String fxMarketUrl;

    @Value("${product.config}")
    private String product;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/info")
    String home() {
        return "Hello World....- " + message + " " + appname + " file = " + product;
    }

    @GetMapping("/forex")
    @LogExecutionTime
    String forex() {

        String  forexMessage = restTemplate.getForObject(fxMarketUrl, String.class);
        return "Forex message....- " + forexMessage;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @LogExecutionTime(value = "employee.post", description = "resource.save")
    public Employee create(@RequestBody Employee employee) {
        ResponseEntity<MarketDate> forexMessage = restTemplate.getForEntity(fxMarketUrl, MarketDate.class);

        MarketDate marketDate = forexMessage.getBody();
        log.info("marketDate = {}", marketDate);
        employee.setPrice(marketDate.getPrice().toString());
        employee.setCurrency(marketDate.getPrice().keySet().stream().collect(Collectors.joining(",")));
        return employeeRepository.save(employee);
    }

    @GetMapping(value = "/{fullName}")
    @LogExecutionTime(value = "employee.get", description = "resource.fetch")
    public Employee get(@PathVariable String fullName) {
        return employeeRepository.findByFullName(fullName).get();
    }

    @GetMapping
    @LogExecutionTime(value = "employee.get", description = "resource.all")
    public List<Employee> getAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @GetMapping(value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE)
    @LogExecutionTime(value = "employee.search", description = "resource")
    public List<Employee> search(@RequestBody Sort searchCriteria) {

        log.info("parameter {}", searchCriteria);
        return (List<Employee>) employeeRepository.findAll();
    }
}
