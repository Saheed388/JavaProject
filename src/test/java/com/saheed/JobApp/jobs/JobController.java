package com.saheed.JobApp.jobs;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    private final JobService jobService;


    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> findAll() {
        return jobService.findAll();
    }


    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job ){
        jobService.createJob(job);
        return "Job Added Successfully";
    }

    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        if (job != null) {
            return job;
        }
        // Return a default job if no job is found
        return new Job(1L, "test", "TestJob",
                "3000", "3000", "Lagos");
    }

}
