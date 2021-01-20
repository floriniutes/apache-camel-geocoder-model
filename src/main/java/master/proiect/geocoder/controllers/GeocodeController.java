package master.proiect.geocoder.controllers;

import org.apache.camel.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/geocode/{address}")
public class GeocodeController {

    private final Logger logger = LoggerFactory.getLogger(GeocodeController.class);

    @Autowired
    @EndpointInject(uri = "direct:start")
    private ProducerTemplate template;

    @Value("${google.map.api.key}")
    private String key;


    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    String code(@PathVariable(name = "address") String address, @RequestParam(name = "outputType") String outputType) {
        if (StringUtils.isEmpty(address.trim())) {
            return "{\"status\": \"ERR\"}";
        }
        final Map<String, Object> headers = new HashMap<>();
        headers.put("address", address);
        headers.put("key", key);
        headers.put("outputType", outputType);


        Exchange exchange = template.send("direct:start", new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                exchange.getIn().setHeaders(headers);

            }
        });

        String out = exchange.getIn().getBody(String.class);
        return out;
    }

}
