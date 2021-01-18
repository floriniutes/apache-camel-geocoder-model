package master.proiect.geocoder.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http4.HttpMethods;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GecodeRoute extends RouteBuilder {

    @Value("${google.map.api.endpoint}")
    private String endPoint;

    @Override
    public void configure() throws Exception {

        from("direct:start")
                .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.GET))
                .setHeader(Exchange.HTTP_QUERY, simple("key=${in.headers.key}&address=${in.headers.address}"))
                .to("https://maps.googleapis.com/maps/api/geocode/json")
                .to(endPoint)
                .marshal().json();

    }
}
