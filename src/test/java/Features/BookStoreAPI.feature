@API
Feature: BookStore API Test

  Scenario: Listing books

    Given BookStore API is ready.
    When A request is sent to receive the books.
    Then The response status code should be 200.

  Scenario: Verify that book list is not empty
    Given BookStore API is ready.
    When A request is sent to receive the books.
    Then The book list should not be empty

  Scenario: User list API performance check
    Given BookStore API is ready.
    When A request is sent to receive the books.
    Then The response status code should be 200.
    And the response time should be less than 3 seconds.

  Scenario: Create new user
    Given BookStore API is ready.
    When A new user is created.
    Then The response status code should be 201
    And The user should be created successfully.

  Scenario: Generate token for user
    Given BookStore API is ready.
    When A request is sent to generate token
    Then The response status token code should be 200.
    And The token should be generated.

  Scenario: Add book to user
    Given BookStore API is ready.
    When A request is sent to add books to the user account.
    Then response status add book code should be 201

  Scenario: Delete book from user
    Given BookStore API is ready.
    When A new user is created.
    And A request is sent to generate token
    And A request is sent to add books to the user account.
    And A request is sent to delete the book from user account
    Then response status delete book code should be 204
