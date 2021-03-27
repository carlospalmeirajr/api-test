package cpmj.Functionalities;

import static io.restassured.RestAssured.given;

import cpmj.Utils.PropertiesLoaderImpl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequestFunc {

	Response response = null;
	static String body = null;

	public Response postResponseValida() {
		
		body = "{\r\n"
				+ "    \"userId\": " + PropertiesLoaderImpl.getValor("userId") + ",\r\n"
				+ "    \"id\": " + PropertiesLoaderImpl.getValor("id") + ",\r\n"
				+ "    \"title\": \"" + PropertiesLoaderImpl.getValor("title") + "\",\r\n"
				+ "    \"body\": \"" + PropertiesLoaderImpl.getValor("body") + "\"\r\n"
				+ "}";
		
		return response = given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(PropertiesLoaderImpl.getValor("url_valida"))
                .then()
                .extract().response();
	}

	public Response postResponseInvalida() {
		
		body = "{\r\n"
				+ "    \"userId\": " + PropertiesLoaderImpl.getValor("userId") + ",\r\n"
				+ "    \"id\": " + PropertiesLoaderImpl.getValor("id") + ",\r\n"
				+ "    \"title\": \"" + PropertiesLoaderImpl.getValor("title") + "\",\r\n"
				+ "    \"body\": \"" + PropertiesLoaderImpl.getValor("body") + "\"\r\n"
				+ "}";
		
		return response = given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(PropertiesLoaderImpl.getValor("url_invalida"))
                .then()
                .extract().response();
	}
	
}
