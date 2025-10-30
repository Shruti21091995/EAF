package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
  public Properties prop;
  public String URL="/EcommerceAutomation/src/test/resources/Config/Config.properties";
  public ConfigReader(String Url)
  {
	  prop=new Properties();
	  try 
	  {
		FileInputStream ip=new FileInputStream(Url);
		prop.load(ip);
	  } 
	  catch (IOException e)
	  {
		e.printStackTrace();
	  }
  }
  
  public String GetPropery(String Key)
  {
	return prop.getProperty(Key);
	  
  }
}
