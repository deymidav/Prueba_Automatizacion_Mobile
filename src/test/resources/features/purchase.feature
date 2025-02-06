@test1
Feature: Compra de productos en SauceLabs

  Scenario Outline: Agregar productos al carrito y validar la compra
    Given estoy en la aplicación de SauceLabs
    And valido que carguen correctamente los productos en la galeria
    When agrego <UNIDADES> del siguiente producto "<PRODUCTO>"
    Then valido el carrito de compra actualice correctamente

    Examples:
      | PRODUCTO                  | UNIDADES |
      | Sauce Labs Bike Light     | 2        |
      | Sauce Labs Bolt T-Shirt   | 1        |
      | Sauce Labs Backpack       | 3        |