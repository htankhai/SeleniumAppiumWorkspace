/**
 * Hello_World.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.webservice;

public interface Hello_World extends javax.xml.rpc.Service {
    public java.lang.String getHello_PortAddress();

    public com.Htan_WebService.www.Htan_SoapWebService getHello_Port() throws javax.xml.rpc.ServiceException;

    public com.Htan_WebService.www.Htan_SoapWebService getHello_Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
