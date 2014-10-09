package com.pwllc.rest;

/**
 * Created by carl_downs on 10/7/14.
 */

import com.codahale.metrics.annotation.Timed;
import com.pwllc.model.AstCQLClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Path("/cassandra")
@Produces(MediaType.APPLICATION_JSON)
public class CassResource {

    private AstCQLClient dao;

    public CassResource(AstCQLClient dao) {
        this.dao = dao;
    }

//    @GET
//    @Timed
//    public EntryRep addEntry (@QueryParam("name") Optional<String> name, @QueryParam("entry") Optional<String> entry) {
//        return new EntryRep();
//    }

    @GET
    @Path("/hello")
    @Timed
    public Iterator<CassResult> getAllSuppliers() {
        List<CassResult> list = new ArrayList<>();
        list.add(new CassResult ("1","tomorrow"));
        list.add(new CassResult ("2","yesterday"));
        list.add(new CassResult ("3","forever"));
        list.add(new CassResult ("4","doctor"));
        return list.iterator();
    }

//    @GET
//    @Path("/init")
//    @Timed
//    public CassResult init() {
//        dao.init();
//        return new CassResult ("init","confirmed");
//    }

    @GET
    @Path("/createTable")
    @Timed
    public CassResult createTable() {
        dao.createTable();
        return new CassResult ("create","confirmed");
    }

    @GET
    @Path("/read")
    @Timed
    public CassResult read(@QueryParam("emplID") int emplID) {
        return dao.read(emplID);
    }

    @GET
    @Path("/update")
    @Timed
    public CassResult update(@QueryParam("emplID") int id, @QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName) {

        HashMap<String,String> updates = new HashMap<>();
        if (firstName != null) {
            updates.put("firstName", firstName);
        }

        if (lastName != null) {
            updates.put("lastName", lastName);
        }

        dao.insertDynamicProperties(id, updates);
        return new CassResult ("update","confirmed");
    }

}