package org.example.exercice_apirest_voiture;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/voiture")
public class VoitureRessource {
    private final VoitureService voitureService;

    @Inject
    public VoitureRessource(VoitureService voitureService){
        this.voitureService = voitureService;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Voiture getVoiture(){
        Voiture voiture = new Voiture(1,"Vulvo","1986","Rouge");
        return  voiture;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Voiture postVoiture(Voiture voiture){
        voiture.setId(1);
        return voiture;
    }

    @DELETE
    @Path("{id}")
    public int delete(@PathParam("id") int id){
        return id;
    }

}
