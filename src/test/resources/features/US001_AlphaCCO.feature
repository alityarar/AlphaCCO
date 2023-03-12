
@US1
Feature: US001 AlphaCCO

  @TC1
  Scenario: TC001 Positive Login Page

    Given User goes "alphaWebSite"
    Then Verify that the Login page is accessible and loads correctly
    And Verify that a user can log in successfully with "userName" and "password"
    And Verify that the user is redirected to their profile page after logging in successfully
    And Verify that the user can log out successfully
    Then Close All

    @TC2
    Scenario: TC002 Negative Login Page
      Given User goes "alphaWebSite"
      Then Enter "fakeUser" and "fakePassword"
      And Verify that the user cannot log in with invalid credentials
      Then Close All

      @TC3
      Scenario: TC003 Forgot Password
        Given User goes "alphaWebSite"
        Then User uses Forgot Password button
        Then The user sends a password reset request by entering their "userName" as e-mail address.
        And Verifies that there is a renewed password in the last message by entering the mail account.
        Then User goes "alphaWebSite"
        And Login with username and new password
        Then Makes a password update by entering old and new passwords
        Then Verifies that can login with "userName" and new password
        And Close All

        @TC4
        Scenario:TC004 Change Password
          Given User goes "alphaWebSite"
          And Entering with the most up -to -date password and user name
          Then Clicks to the change password button
          When Renews the password by entering the latest password and the new password to be made.
          Then Verify that can be logged in with updated password
          And Close All



