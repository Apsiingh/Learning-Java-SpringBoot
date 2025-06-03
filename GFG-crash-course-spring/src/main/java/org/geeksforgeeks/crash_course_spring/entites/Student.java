package org.geeksforgeeks.crash_course_spring.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="student")
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "id" ,nullable = false)
    private Long id;

    @Column(name = "first_name" , nullable = false)
    @NotBlank(message = "FirstName Should not be null.")
    private  String firstName ;

    @Column(name = "last_name" , nullable = false)
    @NotBlank(message = "LastName Should not be null.")
    private  String lastName;

    @Column(name = "email" , nullable = false , unique = false)
    @NotBlank(message = "Email Should not be null.")
    @Email
    private String email;

    @Column(name = "password" , nullable = false)
    private String password;

}