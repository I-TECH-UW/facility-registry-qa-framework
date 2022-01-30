Feature: LAB WorkFlows

@lab  
Scenario Outline: Lab instance should poll facilities from the Facility Registry
  When User Logs in into the Lab instance
  And User goes to the Admininistration Page
  Then Facility "<facilityName>" should exist in Lab instance
  Examples: 
     |facilityName |
     |Isanteplus   |