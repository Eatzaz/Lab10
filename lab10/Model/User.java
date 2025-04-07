package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Size(min=3)
    @Pattern(regexp = ".*[a-zA-Z]")
    @Column(columnDefinition = "varchar(20)not null")
    private String name;
    @Email
    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;
    @NotEmpty
    @Pattern(regexp = "(?=.*.*)(?=.*[a-zA-Z].*)(?=.*[!#$%&?].*).{8,20}")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;
    @NotNull
@Positive
    @Min(21)
    @Column(columnDefinition = "int not null")
    private Integer age;
    @NotEmpty
    @Pattern(regexp = "JOB_SEEKER|EMPLOYER")
    @Column(columnDefinition = "Varchar(15) not null")
    private String role;
}
