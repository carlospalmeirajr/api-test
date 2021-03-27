package cpmj;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import cpmj.Functionalities.GetRequestFunc;
import cpmj.Utils.PropertiesLoaderImpl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Teste {

	static String url = null;
	Response response = null;
	GetRequestFunc resp = new GetRequestFunc();
	
	String body = "{\r\n"
			+ "    \"userId\": " + PropertiesLoaderImpl.getValor("userId") + ",\r\n"
			+ "    \"id\": " + PropertiesLoaderImpl.getValor("id") + ",\r\n"
			+ "    \"title\": \"" + PropertiesLoaderImpl.getValor("title") + "\",\r\n"
			+ "    \"body\": \"" + PropertiesLoaderImpl.getValor("body") + "\"\r\n"
			+ "}";
	
    @Test
    public void getRequest() {
    	
    	
//    	System.out.println(body);
    	
         response = given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(PropertiesLoaderImpl.getValor("url_valida"))
                .then()
                .extract().response();

         System.out.println(response.jsonPath().getString("id"));
         System.out.println(response.statusCode());
         
//        System.out.println(response.getHeaders());
        System.out.println(response.getHeader("Location").toString());
//        
//        Assertions.assertFalse(response.getHeader("Set-Cookie").toString().isEmpty());
//        Assertions.assertEquals(100, response.jsonPath().getList("").size());
//        Assertions.assertEquals(200, response.statusCode());
//        Assertions.assertEquals("qui est esse", response.jsonPath().getString("title[1]"));
//        
    }

    
    
}
