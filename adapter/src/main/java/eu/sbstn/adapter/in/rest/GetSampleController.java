package eu.sbstn.adapter.in.rest;

import eu.sbstn.application.port.in.GetSampleUseCase;
import eu.sbstn.model.Sample;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/sample")
@Produces(MediaType.APPLICATION_JSON)
public class GetSampleController {
    private final GetSampleUseCase getSampleUseCase;

    public GetSampleController(GetSampleUseCase getSampleUseCase) {
        this.getSampleUseCase = getSampleUseCase;
    }

    @GET
    public List<Sample> findBy(){
        return List.of();
    }
}
