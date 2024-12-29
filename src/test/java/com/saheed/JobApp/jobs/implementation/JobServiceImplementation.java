package com.saheed.JobApp.jobs.implementation;

import com.saheed.JobApp.jobs.Job;
import com.saheed.JobApp.jobs.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImplementation implements JobService {
    private final List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;


    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);

    }

    @Override
    public Job getJobById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }

}

