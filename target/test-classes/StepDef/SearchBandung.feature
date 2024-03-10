Feature: Find Bandung City
    User can find jobs by filter based on bandung city

  Scenario: User find occupation in Bandung City
    Given As a user already on homepage
    When User click Search button
    And user click lokasi pekerjaan button
    And User search province Jawa Barat
    And User Search Kota Bandung
    And User Click simpan button
    And Click Lihat semua Button
    Then As a user should be to see result filter Bandung City




