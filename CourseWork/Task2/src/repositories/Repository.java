package repositories;

import daos.DAO;

import java.util.List;

import daos.SQLDAO;
import model.Destination;
import model.GCUTour;

/**
 * Implements model management
 * and acts as an intermediary
 * to a data access object
 */
public class Repository implements RepositoryInterface {
    private final DAO dao;
	
    /**
     * The default constructor which instantiates the dao attribute as a 
     * specified type of Data Access Object
     */
    public Repository() { 
    	dao = new SQLDAO();
    }
    
    /**
     * Responds to a request from the Controller to provide a List of 
     * GCUTour objects.
     * Fulfils this request by sending a getShows() message to the
     * data access object
     */
    @Override
    public List<GCUTour> getGCUTours() {
        return dao.getGCUTours();
    }
    
    /**
     * Responds to a request from the Controller to add a 
     * GCUTour object.
     * Fulfils this request by sending a addAnniversary() message to the
     * data access object
     */    
    @Override
    public void addGCUTour(GCUTour GCUTour) {
        dao.addGCUTour(GCUTour);
    }
    
    /**
     * Responds to a request from the Controller to add a 
     * Destination object.
     * Fulfils this request by sending a addPlace() message to the
     * data access object
     */     
    @Override
    public void addPlace(Destination destination) {
    	dao.addPlace(destination);
    }    
       
    /**
     * Responds to a request from the Controller to provide a specified
     * GCUTour object.
     * Fulfils this request by sending a getShow() message to the
     * data access object
     */    
    @Override
    public GCUTour getGCUTour(int id) {
        return dao.getGCUTour(id);
    }
}
