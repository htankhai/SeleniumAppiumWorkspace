package com.Htan_WebService.www;

public class Htan_SoapWebServiceProxy implements com.Htan_WebService.www.Htan_SoapWebService {
  private String _endpoint = null;
  private com.Htan_WebService.www.Htan_SoapWebService htan_SoapWebService = null;
  
  public Htan_SoapWebServiceProxy() {
    _initHtan_SoapWebServiceProxy();
  }
  
  public Htan_SoapWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initHtan_SoapWebServiceProxy();
  }
  
  private void _initHtan_SoapWebServiceProxy() {
    try {
      htan_SoapWebService = (new org.webservice.Hello_WorldLocator()).getHello_Port();
      if (htan_SoapWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)htan_SoapWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)htan_SoapWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (htan_SoapWebService != null)
      ((javax.xml.rpc.Stub)htan_SoapWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.Htan_WebService.www.Htan_SoapWebService getHtan_SoapWebService() {
    if (htan_SoapWebService == null)
      _initHtan_SoapWebServiceProxy();
    return htan_SoapWebService;
  }
  
  public java.lang.String helloWorld() throws java.rmi.RemoteException{
    if (htan_SoapWebService == null)
      _initHtan_SoapWebServiceProxy();
    return htan_SoapWebService.helloWorld();
  }
  
  public java.lang.String animalType(java.lang.String arg0) throws java.rmi.RemoteException{
    if (htan_SoapWebService == null)
      _initHtan_SoapWebServiceProxy();
    return htan_SoapWebService.animalType(arg0);
  }
  
  public java.lang.String hello_(java.lang.String name) throws java.rmi.RemoteException{
    if (htan_SoapWebService == null)
      _initHtan_SoapWebServiceProxy();
    return htan_SoapWebService.hello_(name);
  }
  
  
}