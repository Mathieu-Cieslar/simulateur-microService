package fr.sdis.client;

import fr.sdis.dto.CaserneDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/casern")
@ApplicationScoped
@RegisterRestClient(configKey = "sim-api")
public interface CasernClient {
    @GET
    List<CaserneDTO> getCasernData();

    @GET
    @Path("/{idCasern}")
    CaserneDTO getCasernById(@PathParam("idCasern") String idCasern);

}
