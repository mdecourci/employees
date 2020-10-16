package co.uk.netpod.application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder(builderClassName = "Builder")
@Entity
@Table(name = "tbl_employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "manager_email")
    private String managerEmail;
    @Column(name = "department")
    private String department;
    @Column(name = "employment_date")
    private LocalDateTime employmentDate;
    @Column(name = "currency")
    private String currency;
    @Column(name = "price")
    private String price;
}
