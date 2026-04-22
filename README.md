# liverpool.technical.test

### Using Gradle depending on the system
Run gradle in Unix/Linux use;
```bash
./gradlew
```

Run gradle in Windows use;
```cmd
gradlew
```

### Configure repo

Resolved dependencies;
```bash
./gradlew --refresh-dependencies
```

### Configure driver
#### For this example, we have a test configuration file for Android (iOS configuration file pending inclusion).
```json
{
  "platform": "Android",
  "capabilities": {
    "platformName": "Android",
    "deviceName": "Android Emulator",
    "automationName": "UiAutomator2",
    "appPackage": "mx.com.liverpool.shoppingapp",
    "appActivity": "mx.com.liverpool.shoppingapp.splash.view.SplashActivity",
    "autoGrantPermissions": true,
    "autoAcceptAlerts": true
  }
}
```
Note: Configuration files in JSON format should be added to the following path `src/main/resources/cfg`

### Environment Variables / Secrets
If you need to load variables or secrets, you can use a `.env` file (not included in the repo)

### Run test suites
Following variables must be sent as arguments:

* `-DloadConfig`: Path to the environment variable is loaded, indicates which configuration file should be used for execution.
* `-Dcucumber.filter.tags`: Cucumber's own argument that indicates the tag of the suite that should be executed

#### Run regression suite (All test with tag @regression)

```bash
./gradlew test -DloadConfig=config_android -Dcucumber.filter.tags="@regression"
```

#### Run by suite

| Suite            | Run                                                                                  |
|------------------|--------------------------------------------------------------------------------------|
| @searchAndFilter | ./gradlew test -DloadConfig=config_android -Dcucumber.filter.tags="@searchAndFilter" |
| @exploreAndSort  | ./gradlew test -DloadConfig=config_android -Dcucumber.filter.tags="@exploreAndSort"  |
| @shoppingCart    | ./gradlew test -DloadConfig=config_android -Dcucumber.filter.tags="@shoppingCart"    |
| @login           | ./gradlew test -DloadConfig=config_android -Dcucumber.filter.tags="@login"           |

Note: It is mandatory that before running any suite, you have Android Studio installed and configured with Emulator set up and Appium.

### Allure Report
Execution report is generated after execution in the following path
`build/reports/allure-report`