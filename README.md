# 📱 ProjectAkko – Mobile Login Automation

## 🔹 Objective
Automate the login workflow of the provided Android application using Appium.

---

## 🛠 Tech Stack Used

- Java 17
- Appium (UiAutomator2)
- TestNG
- Maven
- Page Object Model (POM)
- Extent Reports
- Android Emulator (API 36)

---

## 📂 Framework Structure



---

## ⚙️ Prerequisites

Before running the tests, ensure the following are installed:

1. Java 17+
2. Maven
3. Node.js
4. Appium (installed globally)

Install Appium:



---

## 🚀 How To Run The Tests

### 1️⃣ Start Android Emulator

### 2️⃣ Start Appium Server

### 3️⃣ Run Tests From Project Root



---

## 🧪 Test Coverage

The following login flow is automated:

- Launch application
- Wait for Login screen
- Enter phone number (9995555555)
- Enter password (258814)
- Click Login button
- Handle conditional biometric permission popup
- Validate successful navigation to post-login screen

---

## 🛡 Edge Case Handling

- Biometric permission popup ("DON'T ALLOW") handled dynamically
- Explicit waits used to prevent flaky tests
- Test fails if post-login element is not visible

---

## 📊 Reporting

Extent HTML report is generated after execution.

Report Location:



---

## ✅ Execution Result

Login flow executed successfully on Android Emulator.

✔ Credentials entered successfully  
✔ Biometric popup handled  
✔ Post-login screen validated

---

## 📌 Notes

- APK is included inside the project (`/app` folder) for portability.
- The framework follows Page Object Model for maintainability.
- Explicit waits are used instead of hard waits for stability.
