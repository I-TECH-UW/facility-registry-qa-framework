Feature: FACILITY WorkFlows

@facility 
Scenario Outline: User Should add Facilities to the Facility Registry
  When User Logs in into the Facility Registry instance
  And User Clicks 'Add Organization'
  Then User Enters Organization Details with "<organizationName>"
  When User Clicks 'Add Facility'
  Then User Enters Facility Details with "<facilityName>"
  Examples: 
     |organizationName |facilityName|
     |OpenMRS          |Isanteplus  |