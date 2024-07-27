package eu.sbstn.bootstrap;

import eu.sbstn.application.port.in.AddSampleUseCase;
import eu.sbstn.application.port.in.GetSampleUseCase;
import eu.sbstn.application.port.out.persistence.SampleRepository;
import eu.sbstn.application.service.AddSampleService;
import eu.sbstn.application.service.GetSampleService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

public class QuarkusConfig {

    @Inject
    Instance<SampleRepository> sampleRepository;

    @Produces
    @ApplicationScoped
    GetSampleUseCase getSampleUseCase(){
        return new GetSampleService(sampleRepository.get());
    }

    @ApplicationScoped
    AddSampleUseCase addSampleUseCase(){
        return new AddSampleService(sampleRepository.get());
    }

}
