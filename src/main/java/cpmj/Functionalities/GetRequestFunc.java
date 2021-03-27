package cpmj.Functionalities;

import cpmj.Utils.PropertiesLoaderImpl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetRequestFunc {

	Response response = null;
	
	public Response getResponseValida() {
		 return response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(PropertiesLoaderImpl.getValor("url_valida"))
                .then()
                .extract().response();
	}
	
	public Response getResponseInvalida() {
		 return response = given()
               .contentType(ContentType.JSON)
               .when()
               .get(PropertiesLoaderImpl.getValor("url_invalida"))
               .then()
               .extract().response();
	}
}
