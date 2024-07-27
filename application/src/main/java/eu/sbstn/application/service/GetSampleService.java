package eu.sbstn.application.service;

import eu.sbstn.application.port.in.GetSampleUseCase;
import eu.sbstn.application.port.out.persistence.SampleRepository;
import eu.sbstn.model.Sample;

import java.util.List;

public class GetSampleService implements GetSampleUseCase {

    private final SampleRepository sampleRepository;

    public GetSampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Override
    public List<Sample> getSampleByTitle(String title) {
        return sampleRepository.findByTitle(title);
    }
}
