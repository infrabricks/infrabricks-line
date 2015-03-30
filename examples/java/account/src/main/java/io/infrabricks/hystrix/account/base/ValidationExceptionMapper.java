package io.infrabricks.hystrix.account.base;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

// tag::classdef[]
@Provider
public class ValidationExceptionMapper implements
        ExceptionMapper<ValidationException> {

    @Context
    private HttpHeaders headers;

    @Context
    private Request request;

    @Override
    public Response toResponse(ValidationException e) {
        if(! "POST".equals(request.getMethod())) {
          return Response.status(Status.BAD_REQUEST)
                .entity(new Message(e.getMessage()))
                .type(headers.getMediaType()).build();
        }
        return Response.status(Status.BAD_REQUEST).build();
    }

}
// end::classdef[]
