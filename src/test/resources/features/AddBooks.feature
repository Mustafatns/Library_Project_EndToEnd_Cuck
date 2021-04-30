@addBook
Feature: Adding books as librarian

  Scenario: As a librarian I should be able to add book

    Given The librarian is on login page
    When The librarian logs in  "librarian69@library" and "KNPXrm3S" sees "Dashboard"
    Then Librarian clicks books button and sees "Book Management"
    And Librarian clicks at Add Book button and fills in the fields
    Then Librarian clicks at save changes button


