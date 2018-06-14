package rest;

import dao.TicketDao;
import dao.TripDao;
import pojo.TicketPOJO;
import pojo.TripPOJO;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import java.util.ArrayList;
import java.util.List;

@Path("/trips")
public class TripResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;



    // Return the list of Trips to the user in the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public List<TripPOJO> getTripsBrowser() {
        List<TripPOJO> pojo = new ArrayList<TripPOJO>(TripDao.getInstance().getAllTrips());

        return pojo;
    }

    // Return the list of trips for applications
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<TripPOJO> getTrips()  {
        List<TripPOJO> pojo = new ArrayList<TripPOJO>(TripDao.getInstance().getAllTrips());

        return pojo;
    }

    // retuns the number of trips
    // Use http://localhost:8080/com.vogella.jersey.todo/rest/trips/count
    // to get the total number of records
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = TripDao.getInstance().getAllTrips().size();
        return String.valueOf(count);
    }
    @GET
    @Path("{c}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<TicketPOJO> getUserBooked(@PathParam("c") int c) {
        List<TicketPOJO> pojoBook = new ArrayList<TicketPOJO>(TicketDao.getInstance().getBooktickets(c));

        return pojoBook;
    }

  /**  @DELETE
    public void deleteTodo() {
        TripPOJO pojo= TripDao.getInstance().getAllTrips().get(id);
        if(pojo==null)
            throw new RuntimeException("Delete: Todo with " + id +  " not found");
    }


   @POST
   @Produces(MediaType.TEXT_HTML)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public void newTodo(@FormParam("id") String id,
   @FormParam("summary") String summary,
   @FormParam("description") String description,
   @Context HttpServletResponse servletResponse) throws IOException {
   Todo todo = new Todo(id, summary);
   if (description != null) {
   todo.setDescription(description);
   }
   TodoDao.instance.getModel().put(id, todo);

   servletResponse.sendRedirect("../create_todo.html");
   }

   // Defines that the next path parameter after todos is
   // treated as a parameter and passed to the TodoResources
   // Allows to type http://localhost:8080/com.vogella.jersey.todo/rest/todos/1
   // 1 will be treaded as parameter todo and passed to TodoResource
   @Path("{todo}")
   public TodoResource getTodo(@PathParam("todo") String id) {
   return new TodoResource(uriInfo, request, id);
   }


   **/



}