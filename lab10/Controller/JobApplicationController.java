package com.example.lab10.Controller;

import com.example.lab10.Api.ApiResponse;
import com.example.lab10.Model.JobApplication;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Service.JobApplicationService;
import com.example.lab10.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/jopApp")
@AllArgsConstructor
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;
    @GetMapping("/get")
    public ResponseEntity getJob(){
        return ResponseEntity.status(200).body(jobApplicationService.getJobApp());
    }
    @PostMapping("/add")
    public ResponseEntity addJob(@RequestBody @Valid JobApplication jobApplication, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isTrue=jobApplicationService.ApplyJob(jobApplication);
        if(isTrue){
        return ResponseEntity.status(200).body(new ApiResponse("added Job Success"));}
        return ResponseEntity.status(400).body(new ApiResponse("valid:The user or the job post is not Exist"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJob(@PathVariable Integer id){
        boolean isTrue=jobApplicationService.WithdrawJob(id);
        if(isTrue){
            return ResponseEntity.status(200).body(new ApiResponse("deleted is Success"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Valid:The user not Exist"));
    }
}
