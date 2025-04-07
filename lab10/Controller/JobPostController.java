package com.example.lab10.Controller;

import com.example.lab10.Api.ApiResponse;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jobpost")
@AllArgsConstructor
public class JobPostController {
    private final JobPostService jobPostService;

    @GetMapping("/get")
    public ResponseEntity getJob(){
        return ResponseEntity.status(200).body(jobPostService.getAllJob());
    }
    @PostMapping("/add")
    public ResponseEntity addJob(@RequestBody @Valid JobPost jobPost, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        jobPostService.addJob(jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("added Job Success"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateJob(@PathVariable Integer id,@RequestBody @Valid JobPost jobPost,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isTrue= jobPostService.updateJob(id,jobPost);
        if(isTrue){
        return ResponseEntity.status(200).body(new ApiResponse("updated is Success"));}
        return ResponseEntity.status(400).body(new ApiResponse("Valid:The user not Exist"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJob(@PathVariable Integer id){
        boolean isTrue=jobPostService.deleteJob(id);
        if(isTrue){
            return ResponseEntity.status(200).body(new ApiResponse("deleted is Success"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Valid:The user not Exist"));
    }

    }

