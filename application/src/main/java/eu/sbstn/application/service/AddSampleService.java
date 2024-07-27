package eu.sbstn.application.service;

import eu.sbstn.application.port.in.AddSampleUseCase;
import eu.sbstn.application.port.out.persistence.SampleRepository;
import eu.sbstn.model.Sample;

public class AddSampleService implements AddSampleUseCase {

    private final SampleRepository sampleRepository;

    public AddSampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Override
    public Sample createSample(String title, String description) {
        var sample = new Sample(title, description);
        this.sampleRepository.save(sample);
        return sample;
    }
}
