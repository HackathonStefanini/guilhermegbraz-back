package com.stefanini.entrypoint.handlers;

import com.stefanini.core.exceptions.RegraDeNegocioException;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@ApplicationScoped
public class RegraDeNegocioHandler implements ExceptionMapper<RegraDeNegocioException> {

    @Override
    public Response toResponse(RegraDeNegocioException e) {
        return Response
                .status(e.getStatus())
                .header("Content-Type", MediaType.TEXT_PLAIN)
                .entity(e.getMessage())
                .build();
    }

}
