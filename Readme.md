Fleet Engineers
=====
The service is responsible to give minimum numbers of Fleet Engineers required by the Coup to operate in Berlin.

Steps to run
---
1. Import the project in IntelliJ
2. Run ./gradlew build
3. Run Application from command line using ./gradlew bootRun

Supported Endpoints
---
        path : /fleetEngineers [POST]

Request : Body (JSON)

        { 
          "scooters": [11, 15, 13], 
          "C": 9,
          "P": 5
        }
        
Response : Body

        {
            "fleet_engineers": 7
        }
