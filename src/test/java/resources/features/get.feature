# language:pt

@testes_api
Funcionalidade: Validar o funcionamento da API JSONPlaceholder Método GET

@get @cenario_positivo
  Cenário: Validar o return code 200
  Dado efetuar uma requisição GET válida
  Então validar que o return code da requisição GET é igual a 200

@get @cenario_negativo
  Cenário: Validar o return code 404
  Dado efetuar uma requisição GET inválida
  Então validar que o return code da requisição GET é igual a 404
  
@get @cenario_positivo
  Cenário: Validar o número de itens no Response
  Dado efetuar uma requisição GET válida
  Então validar que o número de itens na lista é igual a 100
  
@get @cenario_positivo
	Cenário: Validar que o Set-Cookie está preenchido no Header
  Dado efetuar uma requisição GET válida
  Então validar que o Set-Cookie está preenchido no Header