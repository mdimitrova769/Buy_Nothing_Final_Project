package lib_rest_controller;

import jakarta.ws.rs.Path;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cs455_martina_final.Ask;
import cs455_martina_final.BoundaryInterface;
import cs455_martina_final.Give;
import cs455_martina_final.Note;
import cs455_martina_final.Otgovor;
import cs455_martina_final.Thank;
import cs455_martina_final.User;
import cs455_martina_final.UserManager;
//import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class REST_controller {
	
	BoundaryInterface bi = new UserManager();
	
	@Path("/accounts")
    @GET
    public Response getAllAccounts(@QueryParam ("key") String keyword,  @QueryParam ("start_date") String start_date, @QueryParam ("end_date") String end_date) {
		
			if (keyword==null && start_date == null && end_date == null) {
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
		        String s = gson.toJson(bi.getAllUsers());
		        return Response.status(Response.Status.OK).entity(s).build();
	    } else {
	    	if (start_date == null && end_date == null) {
	    		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		        String s = gson.toJson(bi.searchAccountKey(keyword));
		        return Response.status(Response.Status.OK).entity(s).build();
	    	}
	    	else {
	    		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		        String s = gson.toJson(bi.searchAccountKeyStartEnd(keyword, start_date, end_date));
		        return Response.status(Response.Status.OK).entity(s).build();
	    	}
}
		
		
        
    }
	
	@Path("/accounts")
    @POST
    public Response createAccount(@Context UriInfo uriInfo, String json) {
        String id;
        // calls the "Create Lamp" use case
        Gson gs = new Gson();
        User new_user = gs.fromJson(json, User.class);
        
        	User user = bi.createAccount(new_user);
            
            id = user.getUid();
            Gson gson = new Gson();
            String s = gson.toJson(user);
            // Build the URI for the "Location:" header
            UriBuilder builder = uriInfo.getAbsolutePathBuilder();
            builder.path(id.toString());

            // The response includes header and body data
            return Response.created(builder.build()).entity(s).build();
      }
	
	@Path("/accounts/{id}/activate")
    @GET
    public Response activateAccount(@PathParam("id") String lid) {
		
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        String s = gson.toJson(bi.activateAccount(lid));
	        return Response.status(Response.Status.OK).entity(s).build();
    }
	
	@Path("/accounts/{id}")
    @PUT
    public Response updateAccount(@PathParam("id") String lid, String json) {
		Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        int check = bi.updateAccount(lid, user);
        if (check == 1) {
            return Response.status(Response.Status.NO_CONTENT).build(); 
        }
        else {
              Otgovor response = new Otgovor();
              
              response.setDetail("You may not use PUT to activate an account, use GET /accounts/"+user.getUid()+"/activate instead");
              response.setInstance("/accounts/"+user.getUid());
              response.setStatus(400);
              response.setTitle("Your request data didn\'t pass validation");
              response.setType("http://cs.iit.edu/~virgil/cs445/mail.spring2022/project/api/problems/data-validation");
                  
                  Gson gson2 = new Gson();
                  String s = gson2.toJson(response);
        	return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(s).build();
        }
    }
	
	@Path("/accounts/{id}")
    @GET
    public Response updateAccountCheck(@PathParam("id") String lid) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(bi.updateAccountCheck(lid));
        return Response.status(Response.Status.OK).entity(s).build();
    }
	
	@Path("/accounts/{id}")
    @DELETE
    public Response deleteAccount(@PathParam("id") String lid) {
        
    	try {
    		bi.deleteUser(lid);
    		// return a 204
    	    return Response.status(Response.Status.NO_CONTENT).build();
    		//Gson gson = new GsonBuilder().setPrettyPrinting().create();
            //String s = gson.toJson(l);
            //return Response.ok(s).build();
    	} catch (Exception e) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + lid).build();
        } 
    }
	
	// ASK -----------------------------------------------------
	@Path("/accounts/{uid}/asks")
    @POST
    public Response createAsk(@Context UriInfo uriInfo, String json, @PathParam ("uid") String uid) {
        
		String id;
        Gson gs = new Gson();
        Ask new_ask = gs.fromJson(json, Ask.class);
        Ask ask = bi.createAsk(new_ask);
            
            
        if (ask.getUid().equalsIgnoreCase("null")) {
            Otgovor response2 = new Otgovor();
            
            response2.setDetail("This account "+uid+" is not active an may not create an ask.");
            response2.setInstance("/accounts/"+uid);
            response2.setStatus(400);
            response2.setTitle("Your request data didn\'t pass validation");
            response2.setType("http://cs.iit.edu/~virgil/cs445/mail.spring2022/project/api/problems/data-validation");
                
                Gson gson2 = new Gson();
                String answer = gson2.toJson(response2);
                return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(answer).build();

        }
        else {
        	id = ask.getAid();
            Gson gson = new Gson();
            String s = gson.toJson(ask);
        	 // Build the URI for the "Location:" header
            UriBuilder builder = uriInfo.getAbsolutePathBuilder();
            builder.path(id.toString());

            // The response includes header and body data
            return Response.created(builder.build()).entity(s).build();
        }
		
      }
	
	@Path("/asks/{id}")
    @GET
    public Response getSpecificAsk(@PathParam("id") String aid) {
        Ask ask = bi.viewAsk(aid);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String s = gson.toJson(ask);
            if (ask.getUid().equals("null")) {
                return Response.status(Response.Status.NOT_FOUND).build(); 
            }else {
            	return Response.ok(s).build();
            }
    }
	
	@Path("/accounts/{uid}/asks/{aid}")
    @PUT
    public Response updateAsk(@PathParam("uid") String uid, @PathParam("aid") String aid, String json) {
		Gson gson = new Gson();
        Ask ask = gson.fromJson(json, Ask.class);
        int check = bi.updateAsk(uid, aid, ask);
        if (check == 1) {
            return Response.status(Response.Status.NO_CONTENT).build(); 
        }
        else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
       
    }
	
	@Path("/accounts/{uid}/asks/{aid}/deactivate")
    @GET
    public Response deactivateAsk(@PathParam("uid") String uid, @PathParam("aid") String aid) {
        
        Ask ask = bi.deactivateAsk(uid, aid);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String s = gson.toJson(ask);
            return Response.ok(s).build();
    }
	
	@Path("/accounts/{uid}/asks")
    @GET
    public Response getAllMyAsks(@PathParam("uid") String uid, @QueryParam ("is_active") String is_active) {
       
		if (is_active==null) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        String s = gson.toJson(bi.getAllMyAsks(uid));
	        return Response.status(Response.Status.OK).entity(s).build();
		}
		else {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        String s = gson.toJson(bi.getAllMyAsksActive(uid, is_active));
	        return Response.status(Response.Status.OK).entity(s).build();
		}
		
		
		
    }
	
	@Path("/asks")
    @GET
    public Response getAllActiveAsks(@QueryParam("v_by") String v_by, @QueryParam ("is_active") String is_active ) {
        
		if (is_active==null && v_by ==null) {
			Otgovor response2 = new Otgovor();
            
            response2.setDetail("Missing query string, please consult the API documentation");
            response2.setInstance("/asks/");
            response2.setStatus(400);
            response2.setTitle("Your request data didn\'t pass validation");
            response2.setType("http://cs.iit.edu/~virgil/cs445/mail.spring2022/project/api/problems/data-validation");
                
                Gson gson2 = new Gson();
                String answer = gson2.toJson(response2);
                return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(answer).build();
		}
		else {
			if (is_active==null) {
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
		        String s = gson.toJson(bi.getAllActiveAsksBy(v_by));
		        return Response.status(Response.Status.OK).entity(s).build();
			}
			else {
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
		        String s = gson.toJson(bi.getAllActiveAsksByActive(v_by, is_active));
		        return Response.status(Response.Status.OK).entity(s).build();

			}
		}
		
		
		
    }
	
	@Path("/accounts/{uid}/asks/{aid}")
    @DELETE
    public Response deleteAsk(@PathParam("uid") String uid, @PathParam("aid") String aid) {
        // call the "Delete Lamp" use case
    	try {
    		bi.deleteAsk(uid, aid);
    		// return a 204
    	    return Response.status(Response.Status.NO_CONTENT).build();
    		//Gson gson = new GsonBuilder().setPrettyPrinting().create();
            //String s = gson.toJson(l);
            //return Response.ok(s).build();
    	} catch (Exception e) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + aid).build();
        } 	
    }
	
	// GIVE -----------------------------------------------------

	@Path("/accounts/{id}/gives")
    @POST
    public Response createGive(@Context UriInfo uriInfo, String json, @PathParam ("id") String uid) {
        String id;

        Gson gs = new Gson();
        Give new_give = gs.fromJson(json, Give.class);
        
        	Give give = bi.createGive(uid, new_give);
            
            
            
            if (give==null) {
            	Otgovor response2 = new Otgovor();
                
                response2.setDetail("This account " + uid + " is not active an may not create a give.");
                response2.setInstance("/accounts/"+uid);
                response2.setStatus(400);
                response2.setTitle("Your request data didn\'t pass validation");
                response2.setType("http://cs.iit.edu/~virgil/cs445/mail.spring2022/project/api/problems/data-validation");
                    
                    Gson gson2 = new Gson();
                    String answer = gson2.toJson(response2);
                    return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(answer).build();
            }
            else {
            	id = give.getGid();
                Gson gson = new Gson();
                String s = gson.toJson(give);
            	 // Build the URI for the "Location:" header
                UriBuilder builder = uriInfo.getAbsolutePathBuilder();
                builder.path(id.toString());
                System.out.println(s);

                // The response includes header and body data
                return Response.created(builder.build()).entity(s).build();

            }
            
    }
	
	@Path("/accounts/{uid}/gives/{gid}")
    @PUT
    public Response updateGive(@PathParam("uid") String uid, @PathParam("gid") String gid, String json) {
		Gson gson = new Gson();
        Give give = gson.fromJson(json, Give.class);
        int check = bi.updateGive(uid, gid, give);
        if (check == 1) {
            return Response.status(Response.Status.NO_CONTENT).build(); 
        }
        else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
	
	@Path("/gives/{id}")
    @GET
    public Response getSpecificGive(@PathParam("id") String gid) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(bi.verifyGiveUpdated(gid));
        return Response.status(Response.Status.OK).entity(s).build();

    }
	
	@Path("/accounts/{uid}/gives")
    @GET
    public Response getAllGives(@PathParam("uid") String uid, @QueryParam ("is_active") String is_active) {
		
		if(is_active==null) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        String s = gson.toJson(bi.getAllGives(uid));
	        return Response.status(Response.Status.OK).entity(s).build();
		}
		else {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        String s = gson.toJson(bi.getAllGivesActive(uid, is_active));
	        return Response.status(Response.Status.OK).entity(s).build();

		}
		
    }
	
	@Path("/accounts/{uid}/gives/{gid}/deactivate")
    @GET
    public Response deactivateGive(@PathParam("uid") String uid, @PathParam("gid") String gid) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(bi.deactivateGive(uid, gid));
        return Response.status(Response.Status.OK).entity(s).build();

    }
	
	@Path("/gives")
    @GET
    public Response viewAccountsByIdActive(@QueryParam("v_by") String v_by, @PathParam("ic_active") String is_active) {
		
		if (is_active==null && v_by ==null) {
			Otgovor response2 = new Otgovor();
            
            response2.setDetail("Missing query string, please consult the API documentation");
            response2.setInstance("/gives/");
            response2.setStatus(400);
            response2.setTitle("Your request data didn\'t pass validation");
            response2.setType("http://cs.iit.edu/~virgil/cs445/mail.spring2022/project/api/problems/data-validation");
                
                Gson gson2 = new Gson();
                String answer = gson2.toJson(response2);
                return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(answer).build();
		}
		else {
			if (is_active==null) {
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
		        String s = gson.toJson(bi.getAllActiveGivesBy(v_by));
		        return Response.status(Response.Status.OK).entity(s).build();
			}
			else {
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
		        String s = gson.toJson(bi.getAllActiveGivesByActive(v_by, is_active));
		        return Response.status(Response.Status.OK).entity(s).build();

			}
		}

    }
	
	///THANK...........................................
	//--------------------------------------------------
	@Path("/accounts/{uid}/thanks")
    @POST
    public Response createThank(@Context UriInfo uriInfo, String json) {
        String id;

        Gson gs = new Gson();
        Thank new_thank = gs.fromJson(json, Thank.class);
        
        	Thank thank = bi.createThank(new_thank);
            
            id = thank.getTid();
            Gson gson = new Gson();
            String s = gson.toJson(thank);
            
            if (s.equals(null)) {
            	// Build the URI for the "Location:" header
                UriBuilder builder = uriInfo.getAbsolutePathBuilder();
                builder.path(id.toString());
                System.out.println(s);

                // The response includes header and body data
                return Response.status(400).entity(s).build();
            }
            else {
            	 // Build the URI for the "Location:" header
                UriBuilder builder = uriInfo.getAbsolutePathBuilder();
                builder.path(id.toString());
                System.out.println(s);

                // The response includes header and body data
                return Response.created(builder.build()).entity(s).build();

            }
            
       }
	
	@Path("/accounts/{uid}/thanks")
    @GET
    public Response getAllMyThanks(@PathParam("uid") String uid) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(bi.getAllMyThanks(uid));
        return Response.status(Response.Status.OK).entity(s).build();
    }
	
	@Path("/thanks/received/{uid}")
    @GET
    public Response getAllUserThanks(@PathParam("uid") String uid) {
        // call the "Get Lamp Detail" use case
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(bi.getAllUserThanks(uid));
        return Response.status(Response.Status.OK).entity(s).build();

    }
	
	//NOTE-------------------------------------
	//------------------------------------------
	
	@Path("/notes")
    @POST
    public Response createNote(@Context UriInfo uriInfo, String json) {
        String id;

        Gson gs = new Gson();
        Note new_note = gs.fromJson(json, Note.class);
        
        	Note note = bi.createNote(new_note);
            
            id = note.getNid();
            Gson gson = new Gson();
            String s = gson.toJson(note);
            
            if (s.equals(null)) {
            	// Build the URI for the "Location:" header
                UriBuilder builder = uriInfo.getAbsolutePathBuilder();
                builder.path(id.toString());
                System.out.println(s);

                // The response includes header and body data
                return Response.status(400).entity(s).build();
            }
            else {
            	 // Build the URI for the "Location:" header
                UriBuilder builder = uriInfo.getAbsolutePathBuilder();
                builder.path(id.toString());
                System.out.println(s);

                // The response includes header and body data
                return Response.created(builder.build()).entity(s).build();

            }
            
       }
	
	@Path("/notes/{nid}")
    @PUT
    public Response updateNote(@PathParam("nid") String nid, String json) {
		Gson gson = new Gson();
        Note note = gson.fromJson(json, Note.class);
        int check = bi.updateNote(nid, note);
        if (check == 1) {
            return Response.status(Response.Status.NO_CONTENT).build(); 
        }
        else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
	
	@Path("/notes")
    @GET
    public Response getAllNotes(@QueryParam ("c_by") String c_by, @QueryParam ("v_by") String v_by, @QueryParam ("type") String type, @QueryParam ("agid") String agid) {
        
		//c_by - created by
		//v_by - viewed by
		//type - ask or give
		//agid - ask/give id
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(bi.getAllNotes());
        return Response.status(Response.Status.OK).entity(s).build();
    }
	
	
	//REPORT-------------------------
	//-------------------------------
	
	@Path("/reports")
    @GET
    public Response getAllReports() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(bi.getAllReports());
        return Response.status(Response.Status.OK).entity(s).build();
    }
	
	
	
	//VARIA----------------------------
	//------------------------------------
	
	
	
	
	
	
	
	
	
}