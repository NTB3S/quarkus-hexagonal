package eu.sbstn.application.port.in;

import eu.sbstn.model.Sample;

import java.util.List;

public interface GetSampleUseCase {
    List<Sample> getSampleByTitle(String title);
}
