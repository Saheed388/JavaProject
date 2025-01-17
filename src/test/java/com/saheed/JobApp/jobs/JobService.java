package com.saheed.JobApp.jobs;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    Boolean updatedJob(Long id, Job updatedJob);
}
