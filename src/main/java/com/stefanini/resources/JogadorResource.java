package com.stefanini.resources;

import com.stefanini.dto.jogador.JogadorAtualizacaoDTO;
import com.stefanini.dto.jogador.JogadorCadastroDTO;
import com.stefanini.dto.jogador.JogadorLoginDTO;
import com.stefanini.dto.token.AuthTokenDTO;
import com.stefanini.parser.JogadorParser;
import com.stefanini.service.JogadorService;
import com.stefanini.service.TokenService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/jogadores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class JogadorResource {

    @Inject
    private JogadorService jogadorService;

    @Inject
    private JogadorParser jogadorParser;

    @Inject
    private TokenService tokenService;

    @GET
    @Path("/{id}")
    public Response pegarPorId(@PathParam("id") Long id) {
        var jogadorDto = jogadorParser.entityToDto(jogadorService.pegarPorId(id));
        return Response.ok().entity(jogadorDto).build();
    }

    @GET
    @Path("/{id}/stefamons")
    public Response pegarPorIdComStefamons(@PathParam("id") Long id) {
        var jogadorDto = jogadorParser.entityToDto(jogadorService.pegarPorIdComStefamons(id));
        return Response.ok(jogadorDto).build();
    }

    @GET
    public Response listarTodos() {
        var jogadoresDtos = jogadorParser.entityToDto(jogadorService.listarTodos());
        return Response.ok().entity(jogadoresDtos).build();
    }

    @POST
    public Response salvar(@Valid JogadorCadastroDTO dto, @Context UriInfo uriInfo) {
        var jogador = jogadorParser.dtoToEntity(dto);
        jogadorService.salvar(jogador, dto.getIdStefamonInicial());
        var uriBuilder = uriInfo.getBaseUriBuilder();
        uriBuilder.path(jogador.getId().toString()); // Cabeçalho Location
        var jogadorDto = jogadorParser.entityToDto(jogador);
        return Response.created(uriBuilder.build()).entity(jogadorDto).build();
    }

    @PUT
    @Path("/{id}")
    public Response alterar(@PathParam("id") Long id, @Valid JogadorAtualizacaoDTO dto) {
        var jogador = jogadorService.alterar(id, jogadorParser.dtoToEntity(dto));
        var jogadorDto = jogadorParser.entityToDto(jogador);
        return Response.ok().entity(jogadorDto).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        jogadorService.deletar(id);
        return Response.noContent().build();
    }

    @POST
    @Path("/login")
    public Response login(@Valid JogadorLoginDTO dto) {
        var jogador = jogadorService.autenticar(dto);
        String token = tokenService.generateToken(jogador);
        return Response.ok().entity(new AuthTokenDTO(token)).build();
    }
}
