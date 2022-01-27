Feature: FACILITY-EMR  WorkFlows


@emr  
Scenario Outline: User Should add Facilities to the Facility Registry
  When User Logs in into the Facility Registry instance
  And User Clicks 'Add Organization'
  Then User Enters Organization Details
  When User Clicks 'Add Facility'
  Then User Enters Facility Details


# @emr  
# Scenario Outline: EMR should poll facilities from the Facility Registry
#   When User Logs in into the EMR
 