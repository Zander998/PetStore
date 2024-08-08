@Tests
Feature: Consulta por id

  @consultarporId @test
  Scenario: Consultar una Orden
    Given la url "https://petstore.swagger.io/v2/store/order/3" del servicio
    When hago la consulta de la Orden
    Then imprimo los articulos