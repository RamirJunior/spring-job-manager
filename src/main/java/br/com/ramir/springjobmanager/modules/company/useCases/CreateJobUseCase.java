package br.com.ramir.springjobmanager.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ramir.springjobmanager.modules.company.entities.Job;
import br.com.ramir.springjobmanager.modules.company.repositories.JobRepository;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;
    
    public Job execute(Job job){
        return this.jobRepository.save(job);
    }
}
