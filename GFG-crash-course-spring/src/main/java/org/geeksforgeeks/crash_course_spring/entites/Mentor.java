package org.geeksforgeeks.crash_course_spring.entites;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="mentor")
@NoArgsConstructor
@Getter
@Setter
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "id" ,nullable = false)
    private Long id;

    @Column(name = "first_name" , nullable = false)
    @NotBlank
    private String firstName;

    @Column(name = "last_name" , nullable = false)
    @NotBlank
    private String lastName;

    @Column(name = "current_company" , nullable = false)
    @NotBlank
    private String currentCompany;

    @Column(name = "yoe" , nullable = false)
    @NotNull
    @Min(0)
    @Max(40)
    private Float yearsOfExperience;
}
