
package com.pahlsoft.megaevent.ws.generated;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "MegaEventServicesEndpointService", targetNamespace = "http://ws.megaevent.pahlsoft.com", wsdlLocation = "http://ajpc:8080/megaevent-services-0.0.1-SNAPSHOT/me?wsdl")
public class MegaEventServicesEndpointService
    extends Service
{

    private final static URL MEGAEVENTSERVICESENDPOINTSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.pahlsoft.megaevent.ws.generated.MegaEventServicesEndpointService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.pahlsoft.megaevent.ws.generated.MegaEventServicesEndpointService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8080/megaevent-services-0.0.1-SNAPSHOT/me?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/megaevent-services-0.0.1-SNAPSHOT/me?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        MEGAEVENTSERVICESENDPOINTSERVICE_WSDL_LOCATION = url;
    }

    public MegaEventServicesEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MegaEventServicesEndpointService() {
        super(MEGAEVENTSERVICESENDPOINTSERVICE_WSDL_LOCATION, new QName("http://ws.megaevent.pahlsoft.com", "MegaEventServicesEndpointService"));
    }

    /**
     * 
     * @return
     *     returns MegaEventServiceEndpoint
     */
    @WebEndpoint(name = "MegaEventServiceEndpointPort")
    public MegaEventServiceEndpoint getMegaEventServiceEndpointPort() {
        return super.getPort(new QName("http://ws.megaevent.pahlsoft.com", "MegaEventServiceEndpointPort"), MegaEventServiceEndpoint.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MegaEventServiceEndpoint
     */
    @WebEndpoint(name = "MegaEventServiceEndpointPort")
    public MegaEventServiceEndpoint getMegaEventServiceEndpointPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.megaevent.pahlsoft.com", "MegaEventServiceEndpointPort"), MegaEventServiceEndpoint.class, features);
    }

}
