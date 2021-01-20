package master.proiect.geocoder.model;

import java.util.List;

public class GeocodeResponse {

    private List<Results> results;

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}
