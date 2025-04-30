# Selenium Login Automation



This project automates the login process, search functionality, and logout process on the [Intervue](https://www.intervue.io/) website using Selenium WebDriver with Java.



## Prerequisites



Before setting up the project, ensure you have the following installed:



- **Java Development Kit (JDK)**: Version 8 or higher

- **Maven**: For dependency management

- **Google Chrome Browser**: Latest version

- **ChromeDriver**: Compatible with your Chrome browser version

- **Git**: For cloning the repository

- **IDE**: IntelliJ IDEA, Eclipse, or any Java-compatible IDE



## Setup Instructions (Windows/macOS)



### Step 1: Clone the Repository



Clone the project to your local machine using Git:



```bash

git clone <repository-url>

cd <repository-directory>

```



### Step 2: Install ChromeDriver



1. Download the ChromeDriver compatible with your Chrome browser version from [here](https://chromedriver.chromium.org/downloads).

2. Extract the `chromedriver.exe` (Windows) or `chromedriver` (macOS) file.

3. Place the ChromeDriver executable in a directory, e.g., `C:\selenium-drivers\` (Windows) or `/usr/local/bin/` (macOS).

4. Update the ChromeDriver path in the `src/main/java/LoginTest.java` file:



```java

System.setProperty("webdriver.chrome.driver", "<path-to-chromedriver>");

```



For example:

- Windows: `"C:\\selenium-drivers\\chromedriver.exe"`

- macOS: `"/usr/local/bin/chromedriver"`



### Step 3: Set Up the .env File



1. Create a file named `.env` in the project root directory (same level as `pom.xml`).

2. Add the following content with your Intervue credentials:



```

EMAIL=your-email@intervue.io

PASSWORD=your-password

```



Example:



```

EMAIL=neha@intervue.io

PASSWORD=Ps@neha@123

```



3. Ensure the `.env` file is included in `.gitignore` to prevent committing sensitive information. Add the following to `.gitignore` if not already present:



```

.env

```



### Step 4: Install Dependencies



1. Open the project in your IDE.

2. Ensure the `pom.xml` file includes the required dependencies, including Selenium WebDriver and `dotenv-java`. Example `pom.xml` dependencies:



```xml

<dependencies>

<dependency>

<groupId>org.seleniumhq.selenium</groupId>

<artifactId>selenium-java</artifactId>

<version>4.8.1</version>

</dependency>

<dependency>

<groupId>io.github.cdimascio</groupId>

<artifactId>java-dotenv</artifactId>

<version>5.2.2</version>

</dependency>

</dependencies>

```



3. Run the following Maven command to download dependencies:



```bash

mvn clean install

```



4. Verify that the external libraries (e.g., Selenium, `dotenv-java`) are listed in your IDE's project structure under "External Libraries" or "Dependencies."



### Step 5: Run the Application



1. Open the `LoginTest.java` file located in the `src/main/java` directory.

2. Run the `main` method using your IDE's "Run" feature or via the command line:



```bash

mvn exec:java -Dexec.mainClass="LoginTest"

```



The script will:



- Open Chrome and navigate to [Intervue](https://www.intervue.io/).

- Log in using credentials from the `.env` file.

- Perform a search for the term "hello."

- Click on a search suggestion.

- Log out and close the browser.



## Troubleshooting



- **ChromeDriver Version Mismatch**: Ensure the ChromeDriver version matches your Chrome browser version. Check your browser version in Chrome's "About" section.

- **Dependencies Not Found**: Verify your internet connection and run `mvn clean install` again.

- **Missing .env File or Credentials**: Ensure the `.env` file exists in the project root and contains `EMAIL` and `PASSWORD` variables. If missing, the script will throw a `NullPointerException`.

- **Element Not Found Errors**: The website's structure may have changed. Update the XPath locators in `LoginTest.java` to match the current website.



This is an assignment submission by Saurabh Jain for the role of QA Intern at Intervue.io.