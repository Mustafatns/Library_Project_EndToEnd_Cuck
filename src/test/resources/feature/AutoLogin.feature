@runAll
Feature: As a user, I should able to login to the library app.
  Verify both student and librarians.

  @AutoFrontEndLogin
  Scenario Outline: Verify both Students and librarians login
    Given the user is on login page
    When the user logs in with "<username>" and "<password>" sees "<page>"
    Examples:
      | username            | password | page      |
      | student142@library  | FJBph6oV | Books     |
      | student143@library  | HziugPen | Books     |
      | student144@library  | LutHHgbl | Books     |
      | librarian69@library | KNPXrm3S | Dashboard |

    @loginApi
    Scenario Outline:Verify status code is successful when both Students and librarians login
      When the user logs in with "<username>" and "<password>" gets status code 200
      Examples:
        | username            | password |
        | student142@library  | FJBph6oV |
        | student143@library  | HziugPen |
        | student144@library  | LutHHgbl |
        | librarian69@library | KNPXrm3S |