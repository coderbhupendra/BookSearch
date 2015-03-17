package api;
import java.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class api {
	final static String apiKey = "AIzaSyAGSdATN3EQL0W9VkPd8EOIesVD1g3UZrM";
	final static String customSearchEngineKey = "010309984855270940887:h3h_85gbhr0";
	
	//base url for the search query
	final static  String searchURL = "https://www.googleapis.com/customsearch/v1?";
	 
	private static String makeSearchString(String qSearch,int start,int numOfResults)
	{
	    String toSearch = searchURL + "key=" + apiKey + "&cx=" + customSearchEngineKey+"&q=";
	     
	    //replace spaces in the search query with +
	    String keys[]=qSearch.split("[ ]+");
	    for(String key:keys)
	    {   
	        toSearch += key +"+"; //append the keywords to the url
	   }        
	     
	        //specify response format as json
	        toSearch+="&alt=json";
	    
	        //specify starting result number
	        toSearch+="&start="+start;
	     
	        //specify the number of results you need from the starting position
	        toSearch+="&num="+numOfResults;
	     
	    return toSearch;
	}
	
	private static String read(String pUrl)
	{
	    //pUrl is the URL we created in previous step
	    try
	   {
	         URL url=new URL(pUrl);
	        HttpURLConnection connection=(HttpURLConnection)url.openConnection();
	        BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String line;
	        StringBuffer buffer=new StringBuffer();
	        while((line=br.readLine())!=null){
	            buffer.append(line);
	            System.out.println(line);
	        }
	        return buffer.toString();
	    }catch(Exception e){
	        e.printStackTrace();
	   }
	    return null;
	}
	
	
	public static void main (String args[])
	{
		String resultans="sorry";
		resultans=makeSearchString("Angelfall", 1, 5);
		read(resultans);
		System.out.print(resultans);
		
		
		
		}
}
