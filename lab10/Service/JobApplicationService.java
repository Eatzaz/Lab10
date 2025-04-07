package com.example.lab10.Service;

import com.example.lab10.Model.JobApplication;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Model.User;
import com.example.lab10.Repository.JobApplicationRepository;
import com.example.lab10.Repository.JobPostRepository;
import com.example.lab10.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;
    private final UserRepository userRepository;
    private final JobPostRepository jobPostRepository;
    public List<JobApplication> getJobApp(){
        return jobApplicationRepository.findAll();
    }
    public String ApplyJob(JobApplication jobApplication){
        User user=userRepository.getById(jobApplication.getUserID());
        JobPost jobPost=jobPostRepository.getById(jobApplication.getJobPostID());
        if(user==null || jobPost==null)return "NOT FOUND";
        for(JobApplication jobApplication1:jobApplicationRepository.findAll()){
      if(user.getId().equals(jobApplication1.getUserID()) && jobPost.getId().equals(jobApplication1.getJobPostID())){
          return "al-r apply";}
      }
        jobApplicationRepository.save(jobApplication);
        return "true";
    }

    public boolean WithdrawJob(Integer id){
        JobApplication jobApplication1=jobApplicationRepository.getById(id);
        if(jobApplication1==null){
            return false;
        }
        jobApplicationRepository.delete(jobApplication1);
        return true;
    }
}
