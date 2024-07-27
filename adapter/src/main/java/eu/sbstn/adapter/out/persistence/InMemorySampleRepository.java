package eu.sbstn.adapter.out.persistence;

import eu.sbstn.application.port.out.persistence.SampleRepository;
import eu.sbstn.model.Sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//@LookupIfProperty
//@ApplicationScoped
public class InMemorySampleRepository implements SampleRepository {

    private final List<Sample> samples = Collections.synchronizedList(new ArrayList<>());

    @Override
    public List<Sample> findByTitle(String title) {
        return samples.stream()
                .filter(e -> e.title().equals(title)).toList();
    }

    @Override
    public void save(Sample sample) {
        this.samples.add(sample);
    }
}
