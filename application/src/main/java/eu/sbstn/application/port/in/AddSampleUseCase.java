package eu.sbstn.application.port.in;

import eu.sbstn.model.Sample;

public interface AddSampleUseCase {
    Sample createSample(String title, String description);
}
