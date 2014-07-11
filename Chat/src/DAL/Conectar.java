/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import java.sql.*;

/**
 *
 * @author diegotopten
 */
public class Conectar {
    
    private Connection conn;
    
    
    public Conectar(String db,String user,String pass)
    {
        registrar();
        obtenerConexion(db,user,pass);
    }
    
    
    private String registrar()
    {
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        return "exito";
    }
    catch(ClassNotFoundException e)
    {
        return "no registrado";
    }
      
    }
      private String obtenerConexion(String db,String user,String pass)
      {
          try
          {
              conn = DriverManager.getConnection("jdbc:mysql://localhost/"+ db,user,pass);
              return "exito";
          }
          catch(SQLException e)
          {
              return "no conectado";
          }
      }
      
      public Statement crearSentencia()
      {
          try
          {
              return conn.createStatement();
          }
          catch(SQLException e)
          {
              return null;
          }
      }
      
         public PreparedStatement crearQuery(String query)
      {
          try
              {
              return conn.prepareStatement(query);
          }
          catch(SQLException e)
          {
              return null;
          }
      }
      
    
}
