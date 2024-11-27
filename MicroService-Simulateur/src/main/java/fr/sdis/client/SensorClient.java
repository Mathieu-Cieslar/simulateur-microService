package fr.sdis.client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/sensor")
@ApplicationScoped
@RegisterRestClient(configKey = "sim-api")
public interface SensorClient {
    @GET
    String getSensorData();
}
