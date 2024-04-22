package viewmodels;

import java.util.List;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.GCUTour;

public class GCUTourView {
    private StringProperty id;
    private StringProperty tourDate;
    private StringProperty tourDuration;
    private List<DestinationView> destinationsVisited;
      
    public GCUTourView(GCUTour GCUTour) {
    	this.id = new SimpleStringProperty(Integer.toString(GCUTour.getId()));
    	this.tourDate = new SimpleStringProperty(GCUTour.getTourDate());
    	this.tourDuration = new SimpleStringProperty(Integer.toString(GCUTour.getTourDuration()));
    	this.destinationsVisited = GCUTour.getDestinationsVisited().stream().map(p -> new DestinationView(p)).collect(Collectors.toList());
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

    public List<DestinationView> getDestinationsVisited() {
            return destinationsVisited;
    }
}
