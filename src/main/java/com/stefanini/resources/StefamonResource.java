package com.stefanini.resources;

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

    @GET
    public Response listarTodos() {
        var stefamonsDtos = stefamonService.listarTodosComPreco();
        return Response.ok(stefamonsDtos).build();
    }

    @GET
    @Path("/{id}")
    public Response pegarPorId(@PathParam("id") Long id) {
        var stefamonDto = stefamonService.pegarPorIdComPreco(id);
        return Response.ok(stefamonDto).build();
    }
}
