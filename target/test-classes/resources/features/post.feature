# language:pt

@testes_api
Funcionalidade: Validar o funcionamento da API JSONPlaceholder Método POST

@post @cenario_positivo
  Cenário: Validar o return code 201
  Dado efetuar uma requisição POST válida
  Então validar que o return code da requisição POST é igual a 201

@post @cenario_negativo
  Cenário: Validar o return code 404
  Dado efetuar uma requisição POST inválida
  Então validar que o return code da requisição POST é igual a 404
  
@post @cenario_positivo
  Cenário: Validar que o novo registro ocupa o id 101
  Dado efetuar uma requisição POST válida
  Então validar que o id do novo registro é igual a 101  
  
@post @cenario_positivo
  Cenário: Validar que o Location está preenchido no Header 
  Dado efetuar uma requisição POST válida
  Então validar que o Location está preenchido no Header