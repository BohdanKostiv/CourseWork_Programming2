package repositories;

import java.util.List;

import model.GCUTour;
import model.Destination;

/**
 *
 * @author mga
 * @author rla
 */
public interface RepositoryInterface {

    /**
     * A class that implements this interface must provide this method
     * 
     * @param GCUTour
     */
    void addGCUTour(GCUTour GCUTour);

    /**
     * A class that implements this interface must provide this method
     * 
     * @param id
     * @return GCUTour
     */
    GCUTour getGCUTour(int id);

    /**
     * A class that implements this interface must provide this method
     * 
     * @return List of GCUTour
     */
    List<GCUTour> getGCUTours();
    
    /**
     * A class that implements this interface must provide this method
     * 
     * @param destination
     */
    void addPlace(Destination destination);
    
}
