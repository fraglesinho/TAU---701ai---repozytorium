Feature:
  Scenario Outline: Login Page Scenerio
    Given Załadowaną stronę logowana
    When Wprowadzam poprawnego użytkownika "<user>" i hasło "<password>"
      And Kliknełem przycisk logowania by się zalogować
    Then Ukazuje mi się strona logowania

    Examples:
    | user                   | password |
    | patryk@kosmala.chelsea | chelsea  |