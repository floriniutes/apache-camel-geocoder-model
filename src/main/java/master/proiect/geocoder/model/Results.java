package master.proiect.geocoder.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Results {

    @JsonProperty("address_components")
    private List<AddressComponent> address_components;
    @JsonProperty("formatted_address")
    private String formatted_address;

    public List<AddressComponent> getAddress_components() {
        return address_components;
    }

    public void setAddress_components(List<AddressComponent> address_components) {
        this.address_components = address_components;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }
}
