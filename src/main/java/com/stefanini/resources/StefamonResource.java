package com.stefanini.resources;

import com.stefanini.parser.StefamonParser;
import com.stefanini.service.StefamonService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/stefamons")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StefamonResource {

    @Inject
    private StefamonService stefamonService;

    @Inject
    private StefamonParser stefamonParser;

    @GET
    public Response listarTodos() {
        var stefamonsDtos = stefamonParser.entityToDTO(stefamonService.listarTodos());
        return Response.ok(stefamonsDtos).build();
    }

    @GET
    @Path("/{id}")
    public Response pegarPorId(@PathParam("id") Long id) {
        var stefamonDto = stefamonParser.entityToDTO(stefamonService.pegarPorId(id));
        return Response.ok(stefamonDto).build();
    }
}
