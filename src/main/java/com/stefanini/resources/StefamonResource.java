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
        var stefamonsComPreco = stefamonService.listarTodosComPreco();
        var stefamonsDtos = stefamonParser.entityToDTO(stefamonsComPreco);
        return Response.ok().entity(stefamonsDtos).build();
    }

    @GET
    @Path("/{id}")
    public Response pegarPorId(@PathParam("id") Long id) {
        var stefamonComPreco = stefamonService.pegarPorId(id);
        var stefamonDto = stefamonParser.entityToDTO(stefamonComPreco);
        return Response.ok().entity(stefamonDto).build();
    }

}
