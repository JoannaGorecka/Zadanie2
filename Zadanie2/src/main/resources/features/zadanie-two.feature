Feature: Zadanie2

  Scenario: user purchases an item from the shop
    Given user is logged in with kruszek99@gmail.com and Pass123 and is on the home page
    Then user selects the size and adds 3 items to the cart
    Then user confirms the address, selects pick up and payment method
    And user takes a screenshot of the order

