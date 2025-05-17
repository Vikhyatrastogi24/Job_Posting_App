package com.Titan.throne.springBoot_rest.service;

import com.Titan.throne.springBoot_rest.model.JobPost;
import com.Titan.throne.springBoot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService
{
    @Autowired
    public JobRepo repo;

    // method to add a jobPost
    public void addJob(JobPost jobPost) {
        repo.save(jobPost);

    }
    //method to return all JobPosts
    public List<JobPost> getAllJobs() {
        return repo.findAll();
    }
    //method to fetch jobs by id
    public JobPost getJob(int postId)
    {
        return repo.findById(postId).orElse(new JobPost());
    }
    //method to update a job
    public void updateJob(JobPost jobPost)
    {
        repo.save(jobPost);
    }
    //method to delete a job by id
    public void deleteJob(int postId)
    {
        repo.deleteById(postId);
    }

    public void load() {
        List<JobPost> jobPosts = new ArrayList<>();
        jobPosts.add(new JobPost(1, "Software Engineer", "Exciting opportunity for a skilled software engineer.", 3, List.of("Java", "Spring", "SQL")));
        jobPosts.add(new JobPost(2, "Data Scientist", "Join our data science team and work on cutting-edge projects.", 5, List.of("Python", "Machine Learning", "TensorFlow")));
        jobPosts.add(new JobPost(3, "Frontend Developer", "Create amazing user interfaces with our talented frontend team.", 2, List.of("JavaScript", "React", "CSS")));
        jobPosts.add(new JobPost(4, "Network Engineer", "Design and maintain our robust network infrastructure.", 4, List.of("Cisco", "Routing", "Firewalls")));
        jobPosts.add(new JobPost(5, "UX Designer", "Shape the user experience with your creative design skills.", 3, List.of("UI/UX Design", "Adobe XD", "Prototyping")));
        List<JobPost> jobs =
                new ArrayList<>(jobPosts);

        repo.saveAll(jobs);


    }

    public List<JobPost> search(String keyword)
    {
 return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword );
    }
}

