Feature:
  Scenario Outline: Register Page Scenerio
    Given Załadowaną stronę z logowaniem użytkownika
    When Wpisuję swoje konto "<user>"
    And Klikam przycisk rejestracji
    Then Ukazuje mi się formularz rejestracji
    And Uzupełniam go swoimi danymi "<password>", "<adres>", "<miasto>", "<imie>", "<nazwisko>", "<telefon>", "<kodpocztowy>"
    Then Wysyłam formularz
    Then Ukazuje mi się strona mojego konta

    Examples:
      | user    | password | adres   | miasto  | imie    | nazwisko | telefon   | kodpocztowy |
      | chelsea | desdses  | chelsea | chelsea | chelsea | chelsea  | 123456789 | 77890       |
      | kosmal  | kek123   | chelsea | chelsea | chelsea | chelsea  | 123456789 | 77890       |
      | cosdosc | kek123   | chelsea | chelsea | chelsea | chelsea  | 123456789 | 77890       |