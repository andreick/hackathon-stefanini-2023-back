package com.stefanini.resources;

import com.stefanini.parser.StefamonParser;
import com.stefanini.service.StefamonService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/stefamon")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StefamonResource {

    @Inject
    private StefamonService stefamonService;

    @Inject
    private StefamonParser stefamonParser;

    @GET
    @Path("/todos")
    public Response listarTodos() {
        var stefamons = stefamonService.listarTodos();
        var stefamonsDtos = stefamonParser.entityToDTO(stefamons);
        return Response.ok().entity(stefamonsDtos).build();
    }

    @GET
    @Path("/{id}")
    public Response pegarPorId(@PathParam("id") Long id) {
        var stefamon = stefamonService.pegarPorId(id);
        var stefamonDto = stefamonParser.entityToDTO(stefamon);
        return Response.ok().entity(stefamonDto).build();
    }

}
