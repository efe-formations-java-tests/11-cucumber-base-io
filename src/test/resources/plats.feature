Feature: Calcul de la commande
  Permettre à un client de commander des plats.

  Scenario: Commander des plats et calculer le montant de la commande
    Given le menu contient les plats suivants
      | nom                | prix  |
      | Salade du chef     |   7.0 |
      | Terrine            |   6.5 |
      | Paupiettes         | 11.50 |
      | Saumon             |  12.0 |
      | Tarte tatin        |   6.2 |
      | Mousse au chocolat |   5.8 |
      | Café               |   2.6 |
      | Verre de vin blanc |   3.5 |
      | Verre de vin rouge |   4.5 |
    When le client commande 1 Terrine
    And le client commande 1 Saumon
    And le client commande 1 Mousse au chocolat
    And le client commande 2 Café
    And le client commande 2 Verre de vin rouge
    And le client a une reduction de 3.0 euros
    Then le montant total devrait être 35.50
