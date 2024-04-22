package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Models GCUTour entities
 *
 * @author Martin Gallacher
 * @author Bobby Law
 */
public class GCUTour {
    private int id;
    private String tourDate;
    private int tourDuration;
    private List<Destination> destinationsVisited;

    /**
     * The default GCUTour constructor
     */
    public GCUTour() {
        this.destinationsVisited = new ArrayList<>();
    }

    /**
     * A constructor which accepts tour date & tour duration values
     */
    public GCUTour(String tourDate, int tourDuration) {
        this.tourDate = tourDate;
        this.tourDuration = tourDuration;
        this.destinationsVisited = new ArrayList<>();
    }

    /**
     * A constructor which accepts id, tour date & tour duration values
     */
    public GCUTour(int id, String tourDate, int tourDuration) {
        this.id = id;
        this.tourDate = tourDate;
        this.tourDuration = tourDuration;
        this.destinationsVisited = new ArrayList<>();
    }

    /**
     * A constructor which accepts id, tour date & tour duration and places visited values
     */
    public GCUTour(int id, String tourDate, int tourDuration, List<Destination> destinationsVisited) {
        this.id = id;
        this.tourDate = tourDate;
        this.tourDuration = tourDuration;
        this.destinationsVisited = destinationsVisited;
    }

    /**
     * A getter for id values
     */
    public int getId() {
        return id;
    }

    /**
     * A setter method for id values
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * A getter for tour date values
     */
    public String getTourDate() {
        return tourDate;
    }

    /**
     * A setter method for tour date values
     */
    public void setTourDate(String tourDate) {
        this.tourDate = tourDate;
    }

    /**
     * A getter for tour duration values
     */
    public int getTourDuration() {
        return tourDuration;
    }

    /**
     * A setter method for tour duration values
     */
    public void setTourDuration(int tourDuration) {
        this.tourDuration = tourDuration;
    }

    /**
     * A getter for places visited values
     */
    public List<Destination> getDestinationsVisited() { return this.destinationsVisited;}
    
    /**
     * Adds a supplied Destination object to the destinations visited attribute
     */
    public void addPlaceVisited(Destination destination) {
        this.destinationsVisited.add(destination);
    }
    
    /**
     * Constructs and returns a String representing the state of the object
     */
    @Override
    public String toString() {
        return "ID: " + Integer.toString(id) + " Tour Date: " + tourDate + " Duration: " + tourDuration + "\nDestinations: " + destinationsVisited;
    }
}
