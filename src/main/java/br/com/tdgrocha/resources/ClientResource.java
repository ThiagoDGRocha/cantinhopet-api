package br.com.tdgrocha.resources;

import br.com.tdgrocha.Resources;
import br.com.tdgrocha.pojos.ClientIn;
import br.com.tdgrocha.pojos.ClientOut;
import br.com.tdgrocha.service.ClientService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path(Resources.CLIENT)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Client resources", description = "Basic resources for Client.")
public class ClientResource {

    @Inject
    ClientService service;

    @POST
    @PermitAll
    public void save(ClientIn dto) { service.save(dto); }

    @GET
    @PermitAll
    public List<ClientOut> listAll() { return service.listAll(); }
}
