Feature: Send Goalcard

@Goalcard
Scenario: Send a GoalCard to an already existent kid
  Given I go to kyle3080 main page
  And I click on Give a GoalCard button
  And I select Start small dream big card
  And I set 50 dollars for Fun fund
  And I set 10 dollars for Savings
  And I set Martin as investor name
  And I set a random email
  And I click on continue button on Customize GoalCard page
  And I set Martin Lescano as the Cardholder name
  And I set the credit card number
  And I submit payment
  Then I validate the information displayed in success page