package com.example.resource;

import com.example.service.LabseqService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;


import java.math.BigInteger;

@Path("/labseq")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@OpenAPIDefinition(
        info = @Info(
                title = "LabSeq API",
                version = "1.0.0",
                description = "API to calculate LabSeq sequence values"
        )
)
public class LabseqResource {

    @Inject
    LabseqService labseqService;

    /**
     * Endpoint to get the Labseq value for a given index.
     *
     * @param n The index of the Labseq sequence.
     * @return The Labseq value at index n.
     */
    @GET
    @Path("/{n}")
    @Operation(
            summary = "Retrieve a LabSeq sequence value",
            description = "Fetches the LabSeq value at the specified index 'n'. The LabSeq sequence is defined as follows: l(n) = l(n-4) + l(n-3) for n > 3."
    )
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Successful retrieval of the LabSeq value",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(type = SchemaType.STRING, format = "bigint"),
                            example = "20"
                    )
            ),
            @APIResponse(
                    responseCode = "400",
                    description = "Invalid input. 'n' should be a non-negative integer."
            ),
            @APIResponse(
                    responseCode = "500",
                    description = "Internal server error. Indicates a problem with the server or the computation."
            )
    })
    @Parameter(name = "n", description = "Index in the LabSeq sequence to retrieve the value for.", required = true, example = "20")
    public Response getLabseq(@PathParam("n") String n) {
        // Call the service to get the Labseq value
        try {
            int index = Integer.parseInt(n);
            if (index < 0) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Negative numbers are not allowed.")
                        .build();
            }
            BigInteger result = labseqService.getLabseqValue(index);
            return Response.ok(result.toString()).build();
        } catch (NumberFormatException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Invalid input. Please provide a non-negative integer.")
                    .build();
        }
    }
}