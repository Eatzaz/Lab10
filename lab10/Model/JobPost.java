package com.example.lab10.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null")
    private String title;
    @NotEmpty
    @Column(columnDefinition = "varchar(25) not null")
    private String description;
    @NotNull
    @Column(columnDefinition = "double not null")
    @Positive
    private Double salary;
    @Column(columnDefinition = "Date not null")
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date postingDate;
}
