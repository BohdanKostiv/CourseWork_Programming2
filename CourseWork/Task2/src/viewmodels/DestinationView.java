package viewmodels;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Destination;

public class DestinationView {
    private StringProperty placeName;
    private StringProperty country;
    private StringProperty GDUTourId;
    
    public DestinationView(Destination episode) {
    	this.placeName = new SimpleStringProperty(episode.getPlaceName());
    	this.country = new SimpleStringProperty(episode.getCountry());
    	this.GDUTourId = new SimpleStringProperty(Integer.toString(episode.getGCUTourId()));
    }
    
    public StringProperty getPlaceName() {
            return placeName;
    }    

    public StringProperty getCountry() {
            return country;
    }

    public StringProperty getGDUTourId() {
            return GDUTourId;
    }	
}
