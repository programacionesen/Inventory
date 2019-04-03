package programmer.objects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import programmer.pojos.SupplierObj;

public class SupplierQuery extends Query<SupplierObj>
{

    public SupplierQuery(String p_strSql)
    {
        super(p_strSql);
    }
    @Override
    public ArrayList<SupplierObj> createArrayList(ResultSet p_CResult)
    {
    ArrayList<SupplierObj> arreglo = null;
     
      SupplierObj CTemp;
      //colocar una variable por cada columna de la tabla
      int iId;
      String strName;
      String strContactName;
      String strTelephone;
      
      
      if (p_CResult!=null)
      {
          try 
          {
              //aca inicializamos el arreglo
              arreglo = new ArrayList<>();
              while(p_CResult.next())
              {
                iId = p_CResult.getInt("id");
                strName = p_CResult.getString("name");
                strContactName= p_CResult.getString("contactname");
                strTelephone = p_CResult.getString("telephone");
                
               //aca creamos una instancia del objeto pojo con los datos de un registro 
                CTemp = new SupplierObj(iId, strName, strContactName, strTelephone);
                //agregar al arreglo
                arreglo.add(CTemp);
              }
          } catch (SQLException ex)
          {
              Logger.getLogger(SupplierQuery.class.getName()).log(Level.SEVERE, null, ex);
          }
          
      }
      //por ultimos regresamos el arreglo ya lleno
      return arreglo;  
    }
    
}
    
   
