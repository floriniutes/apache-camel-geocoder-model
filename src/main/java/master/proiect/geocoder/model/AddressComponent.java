package master.proiect.geocoder.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressComponent {

    @JsonProperty("long_name")
    private String longName;
    @JsonProperty("short_name")
    private String shortName;
    @JsonProperty("type")
    private String[] type;

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }
}
