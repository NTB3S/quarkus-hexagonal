package eu.sbstn.adapter.in.rest;

import eu.sbstn.application.port.in.AddSampleUseCase;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/sample")
@Produces(MediaType.APPLICATION_JSON)
public class AddSampleController {
    private final AddSampleUseCase addSampleUseCase;

    public AddSampleController(AddSampleUseCase addSampleUseCase) {
        this.addSampleUseCase = addSampleUseCase;
    }

    @POST
    public void save(){
        this.addSampleUseCase.createSample("toto","toto");
    }
}
