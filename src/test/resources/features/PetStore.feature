@Tests
Feature: Creacion de una Mascota

  @CrearOrden
  Scenario Outline: Consulta un servicio
    When agrago una mascota con shipDate"<shipDate>", status"<status>", quantity"<quantity>"
    Then con el codigo de estado <codeStatus>
    Examples:

    |shipDate                        |status      | quantity |   codeStatus|
    |  2024-08-08T00:42:31.140Z      | placed     |     2    |     200     |
