package co.uk.netpod.application.endpoints;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.client.MockRestServiceServer;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//@RestClientTest(EmployeeController.class)
public class EmployeeControllerTest {
    
    @LocalServerPort
    private int port;
    
    @Autowired
    private EmployeeController employeeController;
    
    @Autowired
    private MockRestServiceServer server;
    
    @Test
    public void home() {
    }
    
    @Test
    public void create() {
//        Employee employee = new Employee();
//        this.server.expect(requestTo("//employee"))
//                .andExpect(method(HttpMethod.POST))
//                .andExpect(content().json("{\"email\" : \"mdecourci@gmail.com\"}"))
//                .andRespond(withSuccess("{\"id\" : \"1234\", \"email\" : \"mdecourci@gmail.com\"}",
//                        MediaType.APPLICATION_JSON));
//
//        Employee createdEmployee = this.employeeController.create(employee);
//        System.out.println("createdEmployee = " + createdEmployee);
        //assertThat(greeting).isEqualTo("hello");
    }
    
    @Test
    public void get() {
    }
    
    @Test
    public void getAll() {
    }
}