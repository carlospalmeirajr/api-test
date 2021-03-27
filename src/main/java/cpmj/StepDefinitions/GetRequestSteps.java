package cpmj.StepDefinitions;

import org.junit.jupiter.api.Assertions;

import cpmj.Functionalities.GetRequestFunc;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.restassured.response.Response;

public class GetRequestSteps {

	Response response = null;
	GetRequestFunc get = new GetRequestFunc();
	
	@Dado("efetuar uma requisição GET válida")
	public void efetuar_uma_requisição_get_válida() {
	    response = get.getResponseValida();
	}

	@Então("validar que o return code da requisição GET é igual a {int}")
	public void validar_que_o_return_code_da_requisição_get_é_igual_a(Integer int1) {
		Assertions.assertEquals(int1, response.statusCode());
	}

	@Dado("efetuar uma requisição GET inválida")
	public void efetuar_uma_requisição_get_inválida() {
		response = get.getResponseInvalida();
	}

	@Então("validar que o número de itens na lista é igual a {int}")
	public void validar_que_o_número_de_itens_na_lista_é_igual_a(Integer int1) {
		Assertions.assertEquals(int1, response.jsonPath().getList("").size());
	}

	@Então("validar que o Set-Cookie está preenchido no Header")
	public void validar_que_o_set_cookie_está_preenchido_no_header() {
		Assertions.assertFalse(response.getHeader("Set-Cookie").toString().isEmpty());
	}

	
}
