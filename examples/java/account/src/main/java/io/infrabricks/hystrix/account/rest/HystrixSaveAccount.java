package io.infrabricks.hystrix.account.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import io.infrabricks.hystrix.account.base.AbstractSaveAccount;
import io.infrabricks.hystrix.account.base.Account;
import io.infrabricks.hystrix.account.base.IBANValidatorService;
import io.infrabricks.hystrix.account.base.ValidationException;

@Path("/hystrix")
@Api("/hystrix")
public class HystrixSaveAccount extends AbstractSaveAccount {

    private static Logger LOG = LoggerFactory
            .getLogger(HystrixSaveAccount.class);

    @GET
    @Produces("text/plain")
    @ApiOperation("simple hello")
    public Response hello() {
        return Response.status(Status.OK).entity("Hello world").build();
    }

    // tag::hystrix[]
    private static class IBANValidatorCommand extends HystrixCommand<Boolean> {
        private Account account;

        protected IBANValidatorCommand(Account account) {
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory
                    .asKey("iban")));
            this.account = account; // <2>
        }

        @Override
        protected Boolean run() throws Exception {
          try {
            return IBANValidatorService.isValid(account); // <3>
          } catch (Exception e) {
            System.out.println(e);
            throw e;
          }
        }

    }

    @POST
    @ApiOperation("save account data")
    public Response save(Account account) throws ValidationException,
            InterruptedException {
        try {
            if (!new IBANValidatorCommand(account).execute()) { // <1>
                throw new ValidationException("invalid");
            }
        } catch (HystrixRuntimeException e) { // <4>
            if (e.getCause() instanceof InterruptedException) {
                throw (InterruptedException) e.getCause();
            }
            LOG.error("problem with command: {}", e.getMessage());
            return Response.status(Status.SERVICE_UNAVAILABLE).build();
        }
        super.saveToDatabase(account);
        return Response.status(Status.OK).build();
    }
    // end::hystrix[]
}
