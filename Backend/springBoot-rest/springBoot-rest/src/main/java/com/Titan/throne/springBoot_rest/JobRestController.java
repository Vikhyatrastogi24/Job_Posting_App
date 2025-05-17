package com.Titan.throne.springBoot_rest;

import com.Titan.throne.springBoot_rest.model.JobPost;
import com.Titan.throne.springBoot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class JobRestController
{
    @Autowired
private JobService service;
    //@CrossOrigin(origins = "http://localhost:5173")
    @GetMapping(path = "jobPosts" , produces = {"application/json"})
    public List<JobPost> getAllJobs(){
return service.getAllJobs();
    }
    //@CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId) {
        return service.getJob(postId);
    }
    //@CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
      return service.search(keyword);
    }
   // @CrossOrigin(origins = "http://localhost:5173")
        @PostMapping("jobPost")
        public JobPost addJob(@RequestBody JobPost jobPost)
        {
          service.addJob(jobPost);
            return service.getJob(jobPost.getPostId());
        }

    //@CrossOrigin(origins = "http://localhost:5173")
         @PutMapping("jobPost")
        public JobPost updateJob(@RequestBody JobPost jobPost)
        {
            service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
        }
    //@CrossOrigin(origins = "http://localhost:5173")
@DeleteMapping("jobPost/{postId}")
        public String deleteJob(@PathVariable int postId){
         service.deleteJob(postId);
         return "Deleted successfully";
        }
    //@CrossOrigin(origins = "http://localhost:5173")
        @GetMapping("load")
        public String loadData(){
        service.load();
        return "success";
        }

}

