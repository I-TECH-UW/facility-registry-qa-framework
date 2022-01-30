Feature: EMR WorkFlows

@emr  
Scenario Outline: EMR should poll facilities from the Facility Registry
  When User Logs in into the EMR
  And User goes to the Manage Locations Page
  Then Facility "<facilityName>" should exist in EMR instance
  Examples: 
     |facilityName |
     |Isanteplus   |