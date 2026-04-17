@DemoQa
  Feature: Writing Demoqa test scenarios

    @NewUser
    Scenario: Opening a new user page
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      Then Check if the new user page is opened
      When Click on the New User button
      Then The Register page is checked.

    @SuccessfulRegistration
    Scenario: All fields are successfully filled and registered.
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Click on the New User button
      When First Name is entered in accordance with the rules
      When Last Name is entered in accordance with the rules
      When Usurname is entered in accordance with the rules
      When Password is entered in accordance with the rules
      When Recaptcha is bypassed manually
      When Click on the Register button
      Then User checks successful registration message
      When Click on the back to login button.

    @FırstNameEmpty
    Scenario: FirstName is left blank
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Click on the New User button
      When Last Name is entered in accordance with the rules
      When Usurname is entered in accordance with the rules
      When Password is entered in accordance with the rules
      When Recaptcha is bypassed manually
      When Click on the Register button
      Then The first name box is checked.

    @LastNameEmpty
    Scenario:LastName is left blank
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Click on the New User button
      When First Name is entered in accordance with the rules
      When Usurname is entered in accordance with the rules
      When Password is entered in accordance with the rules
      When Recaptcha is bypassed manually
      When Click on the Register button
      Then The Last name box is checked.

    @UserNameEmpty
    Scenario: UserName is left blank
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Click on the New User button
      When First Name is entered in accordance with the rules
      When Last Name is entered in accordance with the rules
      When Password is entered in accordance with the rules
      When Recaptcha is bypassed manually
      When Click on the Register button
      Then The User name box is checked.

    @PasswordEmpty
    Scenario: Password is left blank
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Click on the New User button
      When First Name is entered in accordance with the rules
      When Last Name is entered in accordance with the rules
      When Usurname is entered in accordance with the rules
      When Recaptcha is bypassed manually
      When Click on the Register button
      Then The Password box is checked.

    @AllEmpty
    Scenario: Password is left blank
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Click on the New User button
      When Click on the Register button
      Then The first name box is checked.
      Then The Last name box is checked.
      Then The User name box is checked.
      Then The Password box is checked.

    @PasswordCharacterLimit
    Scenario: Entering less than 8 characters in the password field
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Click on the New User button
      When First Name is entered in accordance with the rules
      When Last Name is entered in accordance with the rules
      When Usurname is entered in accordance with the rules
      When Enter a password shorter than eight characters
      When Recaptcha is bypassed manually
      When Click on the Register button
      Then The warning that appears is checked

    @PasswordIsLowercase
    Scenario: The password is entered in lowercase letters only.
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Click on the New User button
      When First Name is entered in accordance with the rules
      When Last Name is entered in accordance with the rules
      When Usurname is entered in accordance with the rules
      When Enter a password containing only lowercase letters
      When Recaptcha is bypassed manually
      When Click on the Register button
      Then The warning that appears is checked

    @PasswordIsUppercase
    Scenario: The password is entered in Uppercase letters only.
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Click on the New User button
      When First Name is entered in accordance with the rules
      When Last Name is entered in accordance with the rules
      When Usurname is entered in accordance with the rules
      When Enter a password containing only uppercase letters
      When Recaptcha is bypassed manually
      When Click on the Register button
      Then The warning that appears is checked

    @NoSpecialCharacters
    Scenario: Only letters (uppercase/lowercase) and numbers are used in the password (no special characters).
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Click on the New User button
      When First Name is entered in accordance with the rules
      When Last Name is entered in accordance with the rules
      When Usurname is entered in accordance with the rules
      When Enter a password that does not contain any special characters.
      When Recaptcha is bypassed manually
      When Click on the Register button
      Then The warning that appears is checked

    @NoLetters
    Scenario: The password contains only numbers and special characters (no letters).
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Click on the New User button
      When First Name is entered in accordance with the rules
      When Last Name is entered in accordance with the rules
      When Usurname is entered in accordance with the rules
      When Enter a password that does not contain letters
      When Recaptcha is bypassed manually
      When Click on the Register button
      Then The warning that appears is checked

    @NoNumbers
    Scenario: The password contains only letters and special characters (no numbers).
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Click on the New User button
      When First Name is entered in accordance with the rules
      When Last Name is entered in accordance with the rules
      When Usurname is entered in accordance with the rules
      When Enter a password that does not contain numbers.
      When Recaptcha is bypassed manually
      When Click on the Register button
      Then The warning that appears is checked

    @NoRecaptca
    Scenario: All fields are entered correctly,
              but an attempt is made to register without checking the "I'm not a robot" checkbox.
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Click on the New User button
      When First Name is entered in accordance with the rules
      When Last Name is entered in accordance with the rules
      When Usurname is entered in accordance with the rules
      When Password is entered in accordance with the rules
      When Click on the Register button
      Then Robot tick warning message

    @SuccessfulLogin
    Scenario: Log in with the correct username and password.
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Username entry is successful.
      When Password entry is successful.
      When Click on the Login button.
      Then Successful login is checked

    @UsernameLoginEmpty
    Scenario: Username is left blank and password is entered correctly.
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Password entry is successful.
      When Click on the Login button.
      Then the warning message is checked.

    @PasswordLoginEmpty
    Scenario: Password is left blank and password is entered correctly.
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Username entry is successful.
      When Click on the Login button.
      Then The password warning message is checked.

    @Password&UsernameEmpty
    Scenario: Username and password are left blank.
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Click on the Login button.
      Then the warning message is checked.
      Then The password warning message is checked.

    @invalidUsername
    Scenario: invalid username successful password.
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Invalid username entered
      When Password entry is successful.
      When Click on the Login button.
      Then The error message is checked.

    @invalidPassword
    Scenario: invalid password successful username.
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Username entry is successful.
      When Invalid Password entered
      When Click on the Login button.
      Then The error message is checked.

    @invalidUsername&Password
    Scenario: Username and password are entered incorrectly.
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Invalid username entered
      When Invalid Password entered
      When Click on the Login button.
      Then The error message is checked.

    @DropDownMenuSetting
    Scenario:  Adjusting books per page dropdown
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Username entry is successful.
      When Password entry is successful.
      When Click on the Login button.
      Then Successful login is checked
      When User selects Show 10 from the dropdown
      Then Book list container should adjust height to fit rows
      And No layout issues or overlapping elements should occur

    @GotoBookStoreButton
    Scenario: Clicking the Go to Book store button
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Username entry is successful.
      When Password entry is successful.
      When Click on the Login button.
      Then Successful login is checked
      When Click on the Go to book store button.
      Then Check that the book store page is opened.
      When click on a book
      Then The book detail page is examined
      When add book to profile
      Then check if the book appears on your profile

    @Logout
    Scenario: Check the logout button on the profile screen
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Username entry is successful.
      When Password entry is successful.
      When Click on the Login button.
      Then Successful login is checked
      When Click on the logout button.
      Then It is checked that the exit is successful.

    @LoginTab
    Scenario:Access control to the Login tab
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Username entry is successful.
      When Password entry is successful.
      When Click on the Login button.
      Then Successful login is checked
      When Click on the Login tab.
      Then It is checked that the login page is accessed.

    @DeleteallBooksButton
    Scenario: The delete all books button is checked
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Username entry is successful.
      When Password entry is successful.
      When Click on the Login button.
      Then Successful login is checked
      When Click on the Delete all books
      Then The pop-up that appears on the screen is verified
      When Click on the "Ok" button in the pop-up.
      Then the message that pops up on the screen is checked
      When Click on the Delete all books
      When Click on the Cancel button in the pop-up.
      Then Check that you are back to the profile screen.

    @DeleteBooksAccountsButton
    Scenario: The delete all books button is checked
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Username entry is successful.
      When Password entry is successful.
      When Click on the Login button.
      Then Successful login is checked
      When delete accounts button controls
      Then The pop-up that opens is checked.
      When Click on the Cancel button in the pop-up.
      Then It is seen that the popup closes and you return to the profile screen.
      When delete accounts button controls
      When Click on the "Ok" button in the pop-up.
      Then Check the message that appears on the screen

    @BookStoreTab
    Scenario:Switch control to the Book store tab
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Username entry is successful.
      When Password entry is successful.
      When Click on the Login button.
      When Click on the Book Store button.
      Then Check that the book store screen is opened.

    @BookStoreSearchBox
    Scenario:Search Bar area visibility control
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Username entry is successful.
      When Password entry is successful.
      When Click on the Login button.
      When Click on the Book Store button.
      Then Search Bar control

    @SearchBarPositive
    Scenario:An existing book name is entered into the search bar and the list is checked.
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Username entry is successful.
      When Password entry is successful.
      When Click on the Login button.
      When Click on the Book Store button.
      Then Search Bar control
      When Click on the search bar and enter the character.
      Then search result is checked

    @SearchBarNegative
    Scenario:The list is checked by entering an invalid character.
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Username entry is successful.
      When Password entry is successful.
      When Click on the Login button.
      When Click on the Book Store button.
      Then Search Bar control
      When Click on the search field and enter a name that does not exist
      Then Results are checked

    @SearchBarComingBack
    Scenario:List control as a result of deleting entered characters.
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Username entry is successful.
      When Password entry is successful.
      When Click on the Login button.
      When Click on the Book Store button.
      Then Search Bar control
      When characters are entered
      Then the list is checked

    @BookStoreDetail
    Scenario:book detail page control
      Given Demoqa page opens
      When Click on Elements
      When Click on Book Store Application
      When Click on the login option
      When Username entry is successful.
      When Password entry is successful.
      When Click on the Login button.
      When Click on the Book Store button.
      Then Search Bar control
      When click on a book
      Then The book detail page is examined


























