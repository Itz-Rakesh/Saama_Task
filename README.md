1. **Project Overview**: it consist of 3 feature to met the Test scope.
2. **Project Structure**:
   my-cucumber-maven-project/
│
├── src/
│   ├── main/
│   │   └── java/
│   │
│   └── resources/
│
└── test/
    ├── java/
    │   ├── features/
    │   │   ├── DynamicTable.feature               # Feature file for dynamic table tests
    │   │   ├── Login.feature                      # Feature file for login functionality tests
    │   │
    │   ├── pages/
    │   │   ├── DynamicTablePage.java              # Page object for dynamic table interactions
    │   │   ├── LoginPage.java                     # Page object for login page
    │   │
    │   ├── runner/
    │   │   └── TestRunner.java                    # Runner class for executing tests
    │   │
    │   ├── stepDefinition/
    │   │   ├── DynamicTableSD.java                # Step definitions for dynamic table tests
    │   │   └── LoginStepDefinition.java           # Step definitions for login functionality tests
    │   │
    │   └── utility/
    │       └── BrowserDriver.java                 # Utility class for browser actions
    │
    └── resources/
        └── cucumber.json                          # JSON output for Cucumber tests
        └── allure-results                         # to generate allure report

