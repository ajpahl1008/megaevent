
package com.pahlsoft.megaevent.ws.generated;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "Exception", targetNamespace = "http://ws.megaevent.pahlsoft.com")
public class Exception_Exception
    extends java.lang.Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private com.pahlsoft.megaevent.ws.generated.Exception faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public Exception_Exception(String message, com.pahlsoft.megaevent.ws.generated.Exception faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public Exception_Exception(String message, com.pahlsoft.megaevent.ws.generated.Exception faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.pahlsoft.megaevent.ws.generated.Exception
     */
    public com.pahlsoft.megaevent.ws.generated.Exception getFaultInfo() {
        return faultInfo;
    }

}
