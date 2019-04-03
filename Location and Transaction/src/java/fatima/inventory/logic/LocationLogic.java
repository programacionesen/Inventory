package fatima.inventory.logic;
//id, address, zipcode, coordinates, idcity

import fatima.inventory.database.DatabaseX;

public class LocationLogic extends Logic 
{
    public int insertLocationRows(String p_strAddress, int p_iZipCode, int p_iCoordinates,int p_iIdCity) 
    {   
      
      DatabaseX database = getDatabase();
      String strSql = "INSERT INTO inventory.location (id, address, zipcode, coordinates, idcity) "
                + "VALUES(0, '"+p_strAddress+"', '"+p_iZipCode+"', '"+p_iCoordinates+"', '"+p_iIdCity+"');";
                //sysout(Strsql);
      
      int iRows = database.executeNonQueryRows(strSql);
      return iRows;  
    } 
    
}
