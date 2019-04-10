Feature: Android API Test

  Scenario: Add button should work
    When I am on LogTextBox section
    Then Add button should work

  Scenario: Show long notification button should work
    When I am on NotifyWithText section
    Then Show long notification button should work

  Scenario: Should be able to modify check box preference
    When I am on CheckboxPreference section
    Then I should be able to set preference