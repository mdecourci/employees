package co.uk.netpod.application.repository;

import co.uk.netpod.application.model.Employee;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringRunner.class)
@Slf4j
//@SpringBootTest
public class EmployeeRepositoryTest {
    
 //   @Autowired
    EmployeeRepository employeeRepository;
    
   // @Test
    public void shouldSave() {
        Employee employee =  Employee.builder()
                .fullName("Mike Jack")
                .email("mjack@hot.com")
                .department("Eng")
                .managerEmail("aproff@@hot.com")
                .employmentDate(LocalDateTime.of(2018, Month.FEBRUARY, 1, 9, 30))
                .build();
    
        log.info("save {}", employee);

        employeeRepository.save(employee);
        
        employee = Employee.builder()
                .fullName("Anne Summers")
                .email("asummer@gmail.com")
                .department("Clothes")
                .managerEmail("amanager@@hot.com")
                .employmentDate(LocalDateTime.of(2018, Month.APRIL, 13, 9, 30))
                .build();
    
        log.info("save {}", employee);
        employeeRepository.save(employee);
    
        List<Employee> all = (List<Employee>) employeeRepository.findAll();
        log.info("found {}", all);
    }
    
    //@Test
    public void shouldFindCount() {
        // department Eng
        Employee employee = Employee.builder()
                .fullName("Mike Jack")
                .email("mjack@hot.com")
                .department("Eng")
                .managerEmail("aproff@@hot.com")
                .employmentDate(LocalDateTime.of(2018, Month.FEBRUARY, 1, 9, 30))
                .build();
        
        employeeRepository.save(employee);

        employee = Employee.builder()
                .fullName("Sally Jack")
                .email("sjack@hot.com")
                .department("Eng")
                .managerEmail("aproff@@hot.com")
                .employmentDate(LocalDateTime.of(2017, Month.DECEMBER, 1, 9, 30))
                .build();
    
        employeeRepository.save(employee);
    
    
        employee = Employee.builder()
                .fullName("James Jack")
                .email("jjack@hot.com")
                .department("Eng")
                .managerEmail("another@@hot.com")
                .employmentDate(LocalDateTime.of(2018, Month.SEPTEMBER, 5, 9, 30))
                .build();
    
        employeeRepository.save(employee);
        
        employee = Employee.builder()
                .fullName("Anne Summers")
                .email("asummer@gmail.com")
                .department("Clothes")
                .managerEmail("amanager@@hot.com")
                .employmentDate(LocalDateTime.of(2018, Month.APRIL, 13, 9, 30))
                .build();
        
        employeeRepository.save(employee);
    
        employee = Employee.builder()
                .fullName("July Sian")
                .email("jsian@gmail.com")
                .department("Shoes")
                .managerEmail("shoemanager@hot.com")
                .employmentDate(LocalDateTime.of(2015, Month.FEBRUARY, 13, 9, 30))
                .build();
    
        employeeRepository.save(employee);
    
        Long count = employeeRepository.findTotalNumberOfDepartments(LocalDateTime.of(2018, Month.JANUARY, 1, 9, 30),LocalDateTime.of(2018, Month.OCTOBER, 1, 9, 30));
        
        assertThat(count).isEqualTo(3);

    }
    
}