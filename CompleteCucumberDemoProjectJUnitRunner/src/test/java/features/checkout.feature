Feature: Place the order of products

@PlaceOrder
Scenario Outline: Search Experience of Product search in both home and Offers page
Given User is on GreenCart Landing page
When User searched with shortname <Name> and extracted actual name of product
And Added "3" items of the selected product to cart
Then User proceeds to checkout and validate the <Name> items in checkout page
And verify user has ability to enter promo code and place the order 

Examples:
| Name |
| Tom  |
