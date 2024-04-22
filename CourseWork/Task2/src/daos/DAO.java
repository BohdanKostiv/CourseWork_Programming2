package daos;

import java.util.List;

import model.GCUTour;
import model.Destination;

/**
 * An abstract Data Access Object class
 * which specifies the functionality required
 * to interact with a data store and implemented
 * in concrete subclasses
 */
public abstract class DAO {

    /**
     * A Data Access Object needs to be able to fulfill an
     * addAnniversary() request
     */
    public abstract void addGCUTour(GCUTour GCUTour);

    /**
     * A Data Access Object needs to be able to fulfill an
     * addPlace() request
     */
    public abstract void addPlace(Destination destination);

    /**
     * A Data Access Object needs to be able to fulfill a
     * getAnniversary() request when supplied with a vacancy id
     */
    public abstract GCUTour getGCUTour(int GCUTourId);

    /**
     * A Data Access Object needs to be able to fulfill a
     * getAnniversaries() request and return a List of GCUTour objects
     */
    public abstract List<GCUTour> getGCUTours();
}