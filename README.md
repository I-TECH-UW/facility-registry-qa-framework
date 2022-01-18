# Facility Registry Automated Testing Framework.


[![CI BUild](https://github.com/I-TECH-UW/facilityregistry-qaframework/actions/workflows/build.yml/badge.svg)](https://github.com/I-TECH-UW/facilityregistry-qaframework/actions/workflows/build.yml)


## Installing dependencies 

    mvn clean install -DskipTests=true

## Configuration
- Set Your test configurations in [src/test/resources/test.properties](./src/test/resources/test.properties)

- See Feature files under [src/features/isanteplus](./src/features/isanteplus)

### Running tests

1. All Test Features

        mvn test

2. To run individual Test Features/categories ,You need to filter them by the feature filter tag.

        mvn test -Dcucumber.filter.tags='<@tag>'   
   

| Test Feature        |Filter Tag      |
|:------------------: |:-------------: |
| EMR-FR workflows    | @emr           | 
| LIS-FR  workflows   | @lis           |

