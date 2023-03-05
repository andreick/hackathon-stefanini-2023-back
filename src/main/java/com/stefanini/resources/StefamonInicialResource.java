package com.stefanini.resources;

import com.stefanini.service.StefamonService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/stefamons-iniciais")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StefamonInicialResource {

    @Inject
    private StefamonService stefamonService;

    @GET
    public Response listarTodos() {
        var stefamonsDtos = stefamonService.listarStefamonsIniciaisComPreco();
        return Response.ok(stefamonsDtos).build();
    }
}
