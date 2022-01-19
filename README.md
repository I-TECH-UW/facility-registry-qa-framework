# Facility Registry Automated Testing Framework.


[![CI BUild](https://github.com/I-TECH-UW/facilityregistry-qaframework/actions/workflows/build.yml/badge.svg)](https://github.com/I-TECH-UW/facilityregistry-qaframework/actions/workflows/build.yml)


## Installing dependencies 

    mvn clean install -DskipTests=true

## Configuration
- Set Your test configurations in [src/test/resources/test.properties](./src/test/resources/test.properties)

- See Feature files under [src/features](./src/features)

### Running tests

#### Starting the Selenium Chrome remote web driver

1. run   `docker-compose up`

2. Login at http://localhost:7900 , click 'connect' and enter password 'secret' to view the tests executing

#### Running the Tests

1. All Test Features

        mvn test

2. To run individual Test Features/categories ,You need to filter them by the feature filter tag.

        mvn test -Dcucumber.filter.tags='<@tag>'   
   

| Test Feature              |Filter Tag      |
|:-------------------------:|:-------------: |
| FACILITY-EMR workflows    | @emr           | 
| FACILITY-LAB  workflows   | @lab           |



