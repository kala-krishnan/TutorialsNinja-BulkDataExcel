
@homePage
Feature: Launching on to the Tutorials Ninja home page and go to the register page

Scenario: User launching the Tutorials Ninja Home Page

Given User launch the browser and user is in the Tutorial ninja home page
Then User should redirect to the Tutorials Ninja Home Page

Scenario: User is redirecting to the Tutorials Ninja Register Page

When User clicks register from myaccount dropdown
Then User should redirect to the Tutorials Ninja register page

