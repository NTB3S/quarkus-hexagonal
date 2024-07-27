package eu.sbstn.application.port.out.persistence;

import eu.sbstn.model.Sample;

import java.util.List;

public interface SampleRepository {
    List<Sample> findByTitle(String title);
    void save(Sample sample);
}
