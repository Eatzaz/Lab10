package com.example.lab10.Service;

import com.example.lab10.Model.JobPost;
import com.example.lab10.Repository.JobPostRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobPostService {
    private final JobPostRepository jobPostRepository;
    public List<JobPost> getAllJob(){
        return jobPostRepository.findAll();
    }
    public void addJob(JobPost jobPost){
        jobPostRepository.save(jobPost);
    }
    public boolean updateJob(Integer id,JobPost jobPost){
        JobPost jobPost1=jobPostRepository.getById(id);
        if(jobPost==null){
            return false;
        }
        jobPost1.setTitle(jobPost.getTitle());
        jobPost1.setDescription(jobPost.getDescription());
        jobPost1.setSalary(jobPost.getSalary());
        jobPost1.setPostingDate(jobPost.getPostingDate());
        jobPostRepository.save(jobPost);
        return true;
    }
    public boolean deleteJob(Integer id){
        JobPost jobPost=jobPostRepository.getById(id);
        if(jobPost==null){
            return false;
        }
        jobPostRepository.delete(jobPost);
        return true;
    }
}
