/**
 * Hello_WorldLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.webservice;

public class Hello_WorldLocator extends org.apache.axis.client.Service implements org.webservice.Hello_World {

    public Hello_WorldLocator() {
    }


    public Hello_WorldLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Hello_WorldLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Hello_Port
    private java.lang.String Hello_Port_address = "http://htan:8080/WebAppSoap/Hello_World";

    public java.lang.String getHello_PortAddress() {
        return Hello_Port_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Hello_PortWSDDServiceName = "Hello_Port";

    public java.lang.String getHello_PortWSDDServiceName() {
        return Hello_PortWSDDServiceName;
    }

    public void setHello_PortWSDDServiceName(java.lang.String name) {
        Hello_PortWSDDServiceName = name;
    }

    public com.Htan_WebService.www.Htan_SoapWebService getHello_Port() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Hello_Port_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHello_Port(endpoint);
    }

    public com.Htan_WebService.www.Htan_SoapWebService getHello_Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.webservice.Hello_PortBindingStub _stub = new org.webservice.Hello_PortBindingStub(portAddress, this);
            _stub.setPortName(getHello_PortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHello_PortEndpointAddress(java.lang.String address) {
        Hello_Port_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.Htan_WebService.www.Htan_SoapWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                org.webservice.Hello_PortBindingStub _stub = new org.webservice.Hello_PortBindingStub(new java.net.URL(Hello_Port_address), this);
                _stub.setPortName(getHello_PortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Hello_Port".equals(inputPortName)) {
            return getHello_Port();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.org/", "Hello_World");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.org/", "Hello_Port"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Hello_Port".equals(portName)) {
            setHello_PortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
