Feature:
  Scenario Outline: Login Fail Page Scenerio
    Given Załadowaną stronę do logowana
    When Wprowadzam dane użytkownika "<user>" i hasło "<password>"
    And Nacisnełem przycisk logowania by się zalogować
    Then Ukazuje mi się strona logowania z blędem

    Examples:
      | user                   | password |
      | patryk@chelsea.pl      | desdses  |
      | chelsea@chelsea.pl     | kek      |
      | chelsea@kosmal.chelsea | kek      |