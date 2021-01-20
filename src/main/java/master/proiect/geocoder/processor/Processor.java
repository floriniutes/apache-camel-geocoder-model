package master.proiect.geocoder.processor;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import master.proiect.geocoder.model.GeocodeResponse;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component("processor")
public class Processor implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        String result = exchange.getIn().getBody(String.class);
        JsonElement element = new JsonParser().parse(result);
        Gson gson = new Gson();
        GeocodeResponse resultObject = gson.fromJson(element, GeocodeResponse.class);

        String[] arrayOfStrings = resultObject.getResults().get(0).getFormatted_address().split(",");

        String countryName = arrayOfStrings[1];
        String location = arrayOfStrings[0];

        System.out.println(location + " is part of " +countryName);


        exchange.getOut().setBody(result);
    }
}
