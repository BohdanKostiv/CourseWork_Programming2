package model;

/**
 * Models Destination entities
 *
 * @author Martin Gallacher
 */
public class Destination {
	
    private final String placeName;
    private final String country;
    private final int GCUTourId;

    /**
     * A constructor which accepts place name, country, and anniversary id values
     */
    public Destination(String placeName, String country, int GCUTourId) {
    	this.placeName = placeName;
        this.country = country;
        this.GCUTourId = GCUTourId;
    }
      
    /**
     * A getter for place name values
     */
    public String getPlaceName() {
        return placeName;
    }

    /**
     * A getter for country values
     */
    public String getCountry() {
        return country;
    }

    /**
     * A getter for anniversary id values
     */
    public int getGCUTourId() {
        return GCUTourId;
    }
    
    /**
     * Constructs and returns a String representing the state of the object
     */
    @Override
    public String toString() {
        return "Destination Name: " + placeName + " Country: " + country + " GCUTour: " + Integer.toString(GCUTourId) + "\n";
    }
    
}
