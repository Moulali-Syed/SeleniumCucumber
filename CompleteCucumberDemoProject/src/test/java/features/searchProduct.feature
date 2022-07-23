Feature: Search and Place the order of products


#Scenario: Search Experience of Product search in both home and Offers page
#Given User is on GreenCart Landing page
#When User searched with shortname "tom" and extracted actual name of product
#Then User searched for "tom" shortname in offers page 
#And validate product name in offers page matches with landing page



Scenario Outline: Search Experience of Product search in both home and Offers page
Given User is on GreenCart Landing page
When User searched with shortname <Name> and extracted actual name of product
Then User searched for <Name> shortname in offers page 
And validate product name in offers page matches with landing page

Examples:
| Name |
| Tom  |
| Beet |