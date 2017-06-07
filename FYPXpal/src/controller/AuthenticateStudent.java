package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class AuthenticateStudent
 */
@WebServlet("/AuthenticateStudent")
public class AuthenticateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			HashMap<String, String> responseMap = new HashMap<String, String>();
            Gson gson = new GsonBuilder().create();
            StringBuffer jb = new StringBuffer();
            String line = null;
            String username = "";
            String password = "";
            try{
                BufferedReader reader = request.getReader();
                while((line = reader.readLine())!= null){
                    jb.append(line);
                }
            } catch (Exception e){
                System.out.println("Error!!!");
            }
            try{
                JsonParser parser = new JsonParser();
                JsonObject obj = parser.parse(jb.toString()).getAsJsonObject();            
                username = obj.get("username").getAsString();
                password = obj.get("password").getAsString();
                responseMap.put("User name is: ", ">>>"+username+"<<<<");
                responseMap.put("Password is: ", ">>>"+password+"<<<<");
            } catch (IllegalStateException ex){
            	HttpPost httppost = new HttpPost("https://hooks.slack.com/services/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");
           	 httppost.addHeader("Content-type", "application/json");
           	 String message = "@boonsing \nMalformed Json!!!";
           	 StringEntity entity = new StringEntity("{\"text\" : \""+message+"\"}","UTF-8");
           	 entity.setContentType(new BasicHeader("Content-Type",
           		        "application/atom+xml"));
           	            httppost.setEntity(entity);
           	            HttpClient httpclient = HttpClientBuilder.create().build();
           	            HttpResponse response1 = httpclient.execute(httppost);
                System.out.println("Malformed");
                ex.printStackTrace();
            }
                
            if (username != null && !username.equals("") && password != null && !password.equals("")){
                responseMap.put("success", "Came in"); 
                HttpClient client1 = HttpClientBuilder.create().build();
                try{                 
                	 HttpPost httppost = new HttpPost("https://hooks.slack.com/services/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");
                	 httppost.addHeader("Content-type", "application/json");
                	 String message = "@boonsing \nSuccessfully login!!";
                	 StringEntity entity = new StringEntity("{\"text\" : \""+message+"\"}","UTF-8");
                	 entity.setContentType(new BasicHeader("Content-Type",
                		        "application/atom+xml"));
                	            httppost.setEntity(entity);
                	            HttpClient httpclient = HttpClientBuilder.create().build();
                	            HttpResponse response2 = httpclient.execute(httppost);
                } catch(Exception e){
                	e.printStackTrace();
                } finally {
                    client1.getConnectionManager().shutdown();
                }
            } else {                
                responseMap.put("status", "Error");
            }     
            out.println(gson.toJson(responseMap));
        } catch(Exception e){
        	HttpPost httppost = new HttpPost("https://hooks.slack.com/services/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");
          	 httppost.addHeader("Content-type", "application/json");
          	 String message = "@boonsing \nSome variable might be missing :)";
          	 StringEntity entity = new StringEntity("{\"text\" : \""+message+"\"}","UTF-8");
          	 entity.setContentType(new BasicHeader("Content-Type",
          		        "application/atom+xml"));
          	            httppost.setEntity(entity);
          	            HttpClient httpclient = HttpClientBuilder.create().build();
          	            HttpResponse response3 = httpclient.execute(httppost);
            e.printStackTrace();
        }
	}
}
