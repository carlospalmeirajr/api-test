package cpmj.StepDefinitions;

import org.junit.jupiter.api.Assertions;

import cpmj.Functionalities.PostRequestFunc;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.restassured.response.Response;

public class PostRequestSteps {

	Response response = null;
	PostRequestFunc post = new PostRequestFunc();
	
	@Dado("efetuar uma requisição POST válida")
	public void efetuar_uma_requisição_post_válida() {
	    response = post.postResponseValida();
	}
	
	@Dado("efetuar uma requisição POST inválida")
	public void efetuar_uma_requisição_post_inválida() {
		response = post.postResponseInvalida();
	}

	@Então("validar que o return code da requisição POST é igual a {int}")
	public void validar_que_o_return_code_da_requisição_post_é_igual_a(Integer int1) {
		Assertions.assertEquals(int1, response.statusCode());
	}
	
	@Então("validar que o id do novo registro é igual a {int}")
	public void validar_que_o_id_do_novo_registro_é_igual_a(Integer int1) {
		Assertions.assertEquals(int1, Integer.parseInt(response.jsonPath().getString("id")));
	}
	
	@Então("validar que o Location está preenchido no Header")
	public void validar_que_o_location_está_preenchido_no_header() {
		Assertions.assertFalse(response.getHeader("Set-Cookie").toString().isEmpty());
	}
}
