package daos;

import java.util.ArrayList;
import java.util.List;

import model.Destination;
import model.GCUTour;

/**
 * An Test Data Access Object class
 * to hard code test data for
 * anniversaries and places.
 */
public class TextDAO extends DAO {
	List<GCUTour> GCUToursList;

    /**
     * Initializes and populates the anniversaries list
     * with test data.
     */
    public TextDAO() {
        GCUToursList = new ArrayList<>();
        GCUTour GCUTour;
        Destination destination;
        GCUTour = new GCUTour(1, "24/03/2024", 7);
        destination = new Destination("Paris", "France", 1);
        GCUTour.addPlaceVisited(destination);
        destination = new Destination("London", "England", 1);
        GCUTour.addPlaceVisited(destination);
        destination = new Destination("Manchester", "England", 1);
        GCUTour.addPlaceVisited(destination);
        GCUToursList.add(GCUTour);
        GCUTour = new GCUTour(2, "22/04/2024", 14);
        destination = new Destination("Barcelona", "Spain", 2);
        GCUTour.addPlaceVisited(destination);
        destination = new Destination("Girona", "Spain", 2);
        GCUTour.addPlaceVisited(destination);
        GCUToursList.add(GCUTour);
        GCUTour = new GCUTour(3, "06/06/2024", 10);
        destination = new Destination("New York", "USA", 3);
        GCUTour.addPlaceVisited(destination);
        destination = new Destination("New Jersey", "USA", 3);
        GCUTour.addPlaceVisited(destination);
        GCUToursList.add(GCUTour);
    }
    
    /**
     * Overrides the abstract method specified in the DAO class
     * and returns a List of GCUTour objects as requested
     */
    @Override
	public List<GCUTour> getGCUTours() {
        return GCUToursList;
    }
    
    /**
     * Overrides the abstract method specified in the DAO class,
     * accepts a show id value
     * and returns a matching GCUTour object or null as requested
     */
    @Override
	public GCUTour getGCUTour(int GCUTourId) {
        for (GCUTour GCUTour : GCUToursList) {
            if (GCUTour.getId() == GCUTourId) {
                return GCUTour;
            }
        }    	
        return null;
    }
    
    /**
     * Overrides the abstract method specified in the DAO class,
     * accepts an GCUTour object and adds it to the list
     */
    @Override
    public void addGCUTour(GCUTour GCUTour) {
        int GCUTourId = GCUToursList.stream().map(model.GCUTour::getId).max(Integer::compare).get()+1;
        GCUTour.setId(GCUTourId);
        GCUToursList.add(GCUTour);
    }
    
    /**
     * Overrides the abstract method specified in the DAO class,
     * accepts a destination object and updates an anniversary in the list
     */
    @Override
	public void addPlace(Destination destination) {
        for (GCUTour GCUTour : GCUToursList) {
            if (GCUTour.getId() == destination.getGCUTourId()) {
                GCUTour.addPlaceVisited(destination);
            }
        }    	
    }  
}
