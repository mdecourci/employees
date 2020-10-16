package co.uk.netpod.application.repository;

import co.uk.netpod.application.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Optional<Employee> findByFullName(String fullName);
    
    /**
     * find total number of distint departments
     * @return
     */
    @Query("select count(DISTINCT department) from Employee e where e.employmentDate > :fromdate and e.employmentDate < :todate ")
//    @Query(nativeQuery = true, value = "select count(my_count) from (select count(*) as my_count from tbl_employee e where e.full_name = :fullName group by e.department)")
//    @Query("select count(*) from (select count(*) as number from Employee e where 1=1 group by e.department) where 1=1 group by number")
    Long findTotalNumberOfDepartments(LocalDateTime fromdate, LocalDateTime todate);
}
