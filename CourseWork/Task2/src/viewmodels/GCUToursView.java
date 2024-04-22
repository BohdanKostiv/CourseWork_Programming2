package viewmodels;

import java.util.List;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.GCUTour;

public class GCUToursView {
    private StringProperty id;
    private StringProperty tourDate;
    private StringProperty tourDuration;
    private List<DestinationView> placesVisited;
      
    public GCUToursView(GCUTour GCUTour) {
    	this.id = new SimpleStringProperty(Integer.toString(GCUTour.getId()));
    	this.tourDate = new SimpleStringProperty(GCUTour.getTourDate());
    	this.tourDuration = new SimpleStringProperty(Integer.toString(GCUTour.getTourDuration()));
    	this.placesVisited = GCUTour.getDestinationsVisited().stream().map(p -> new DestinationView(p)).collect(Collectors.toList());
    }

    public StringProperty getId() {
            return id;
    }

    public StringProperty getTourDate() {
            return tourDate;
    }

    public StringProperty getTourDuration() {
            return tourDuration;
    }

    public List<DestinationView> getPlacesVisited() {
            return placesVisited;
    }
}
