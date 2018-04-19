package com.grupodotrest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import com.grupodotrest.pojo.*;
import javax.ws.rs.Produces;
 
@Path("/hello")
public class Cotizador {
    
    
    
      protected Connection getConnection() throws SQLException, NamingException {
        InitialContext ic = new InitialContext();
        DataSource ds = (DataSource) ic.lookup("jdbc/myDatasource");
        return ds.getConnection();
    }
    
      private Socio convertirAPojo(ResultSet rs ) throws SQLException{
      Socio socio  = new Socio();
      socio.setId(rs.getInt("id"));
      socio.setNombre(rs.getString("nombre"));
      socio.setTasa(rs.getDouble("tasa"));
      socio.setMontoMaximo(rs.getDouble("montoMaximo"));
      
      return socio;
      } 
 
      private Socio evaluarCotizacion(ArrayList socios, double cotizacion){
          Socio aux =(Socio) socios.get(0);
          Socio socioAux =(Socio) socios.get(0);
          double min = aux.getTasa();
          for (Object socio : socios) {
              if (true) {
                  aux = (Socio) socio;
                  
                  if (aux.getTasa() < min) {
                      min = aux.getTasa();
                      socioAux = aux;
                  }
                  
              }
          }
          
          if (cotizacion > socioAux.getMontoMaximo()) {
              socioAux.setId(-1);
          }else {
              socioAux.setCuotaMensual((cotizacion * (1/socioAux.getTasa()))/(1 - Math.pow((1+(1/socioAux.getTasa())),36) ));
              socioAux.setPagoTotal(socioAux.getCuotaMensual()*36);
          
          } 
          
      return socioAux; 
      }
      
      
    @GET
    @Path("/{param}")
    @Produces("application/json")
    public Response getMsg(@PathParam("param") String message) throws SQLException, NamingException {
        
        ArrayList<Socio> socios = new ArrayList();
        Connection db = getConnection();
        ResultSet rs;
        int x = 0;
        try {
            PreparedStatement st = db.prepareStatement("SELECT id, nombre, tasa, montoMaximo from cotizacion.socios");
            rs = st.executeQuery();
           while (rs.next()) {
               Socio socioTmp  = (Socio) convertirAPojo(rs);
               socios.add(socioTmp);
            } 
        } finally {
            db.close();
        }
        
        Socio resp = evaluarCotizacion(socios, Double.parseDouble(message));
        String output = "Socio " + resp.getNombre() + " Cuota Mensual " + resp.getCuotaMensual() +" Pago Total  "+ resp.getPagoTotal() + " Tasa " + resp.getTasa();
        
        
        return Response.status(200).entity(output).build();
    }
}