# Project
Appium based framework to test Native Android App - ebay App chosen for this purpose

## Installation & Setup

1. Download Genymotion to conbnigure emulators. (Check in Desired capabilities setup in base class)
2. Appium Server  - configured IP address - 0.0.0.0 & Port 4723
3. Create Maven project using Java and include below dependencies in pom.xml

Testng &&
appium client &&
selenium-java
Genymotion for emulator launch


## Usage
This is to test Amazon mobile android App function for below scenario
Scenario: Verify a user should be logged in to purchase an item.

Given Amazon shopping app is launched

When User skip sign in
And Click on Search items

And Search for 65 inch tv

And User is navigated to webview with item listed

Then Create account button should be displayed

And User should be able to make a purchase



