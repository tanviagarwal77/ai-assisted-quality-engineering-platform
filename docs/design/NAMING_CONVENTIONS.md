# AI-Assisted Quality Engineering Platform

# NAMING_CONVENTIONS.md

**Version:** 1.0  
**Project:** AI-Assisted Quality Engineering Platform  
**Language:** Java 21  
**Build Tool:** Maven  
**Primary IDE:** Visual Studio Code  

---

# 1. Purpose

This document defines the naming conventions used throughout the AI-Assisted Quality Engineering Platform.

Consistent naming is essential for:

- Readability
- Maintainability
- Code reviews
- Team collaboration
- Debugging
- Automation scalability
- AI-assisted code generation
- Static code analysis
- Long-term framework maintenance

All contributors must follow these conventions when creating or modifying code.

---

# 2. General Naming Principles

The following principles apply to all code:

1. Names must clearly communicate intent.
2. Avoid abbreviations unless they are universally understood.
3. Prefer descriptive names over short names.
4. Avoid names that require comments to explain their purpose.
5. Use domain terminology consistently.
6. Follow standard Java naming conventions.
7. Avoid ambiguous names.
8. Avoid unnecessary prefixes and suffixes.
9. Boolean variables should read like questions or states.
10. Test names should describe behavior rather than implementation.
11. AI-related components should use terminology consistently.
12. Names must be searchable and understandable by developers and AI tools.

---

# 3. Package Naming Convention

Java packages must:

- Be lowercase.
- Use meaningful names.
- Avoid underscores.
- Avoid hyphens.
- Avoid unnecessary nesting.

## Correct

```java
com.tanvi.qa.ai
com.tanvi.qa.api
com.tanvi.qa.driver
com.tanvi.qa.pages
com.tanvi.qa.services
```

## Incorrect

```java
com.tanvi.qa.AI
com.tanvi.qa.TestCases
com.tanvi.qa.test_utils
com.tanvi.qa.test-automation
```

---

# 4. Base Package

The base package is:

```java
com.tanvi.qa
```

All production code must be placed under this package.

Example:

```text
com.tanvi.qa
├── ai
├── api
├── config
├── constants
├── driver
├── exceptions
├── factory
├── listeners
├── models
├── pages
├── reports
├── services
├── utilities
└── validators
```

---

# 5. Class Naming Convention

Classes must use **PascalCase**.

Each significant word should begin with an uppercase letter.

## Correct

```java
LoginPage
TransferService
DriverFactory
ConfigReader
RequirementAnalyzer
FailureAnalyzer
BugReportGenerator
TestCaseGenerator
```

## Incorrect

```java
loginpage
login_Page
Login_Page
loginPage
transfer_service
```

---

# 6. Interface Naming

Interfaces should use PascalCase and describe a capability or contract.

## Correct

```java
AIProvider
BrowserManager
TestDataProvider
ResponseValidator
```

Avoid unnecessary prefixes such as:

```java
IAIProvider
IBrowserManager
ITestDataProvider
```

The framework will follow modern Java conventions and avoid the `I` prefix.

---

# 7. Abstract Class Naming

Abstract classes should use PascalCase.

Where appropriate, use `Base` or `Abstract` to communicate their role.

Examples:

```java
BasePage
BaseTest
BaseApiClient
BaseAIService
```

or:

```java
AbstractAIProvider
AbstractValidator
```

Use `Base` when the class provides shared framework behavior.

Use `Abstract` when the class represents an abstract conceptual implementation.

---

# 8. Enum Naming

Enum types use PascalCase.

Example:

```java
BrowserType
Environment
ExecutionMode
AIProvider
UserRole
TransactionStatus
```

Enum constants use uppercase letters with underscores.

```java
public enum BrowserType {
    CHROME,
    FIREFOX,
    EDGE,
    SAFARI
}
```

---

# 9. Method Naming

Methods must use **camelCase**.

Names should describe an action.

## Correct

```java
login()
transferMoney()
getAccountBalance()
generateTestCases()
analyzeFailure()
createBugReport()
validateResponse()
```

## Incorrect

```java
Login()
TransferMoney()
get_balance()
GenerateTests()
```

---

# 10. Method Naming Guidelines

Use verbs for methods.

Examples:

```java
createUser()
deleteUser()
updateProfile()
getTransaction()
validateBalance()
generateReport()
analyzeLogs()
```

Avoid vague names:

```java
process()
doSomething()
handle()
execute()
run()
```

unless the context makes the purpose explicit.

---

# 11. Boolean Method Naming

Boolean methods should begin with terms such as:

```text
is
has
can
should
contains
exists
```

Examples:

```java
isLoggedIn()
isTransactionSuccessful()
hasBeneficiary()
canTransferMoney()
shouldRetry()
containsError()
exists()
```

Avoid:

```java
loginStatus()
checkLogin()
status()
```

when the method returns a boolean.

---

# 12. Variable Naming

Variables must use camelCase.

## Correct

```java
String userName;
String accountNumber;
double transferAmount;
String transactionId;
```

## Incorrect

```java
String UserName;
String account_number;
String ACCOUNTNUMBER;
double TransferAmount;
```

---

# 13. Variable Names Must Communicate Meaning

Avoid:

```java
String data;
String value;
String temp;
String obj;
String result;
```

unless the context genuinely makes them meaningful.

Prefer:

```java
String customerData;
String transactionStatus;
String authenticationToken;
String expectedBalance;
```

---

# 14. Collection Naming

Collection variables should communicate what they contain.

## Correct

```java
List<User> users;
List<Transaction> transactions;
Set<String> beneficiaryIds;
Map<String, Account> accountsByCustomerId;
```

## Incorrect

```java
List<User> list;
Set<String> set;
Map<String, Account> map;
```

---

# 15. Constants

Constants must use:

```text
UPPER_SNAKE_CASE
```

Examples:

```java
DEFAULT_TIMEOUT
MAX_RETRY_COUNT
BASE_URL
API_VERSION
SCREENSHOT_DIRECTORY
REPORT_DIRECTORY
```

Example:

```java
public static final int DEFAULT_TIMEOUT = 30;
```

---

# 16. Test Class Naming

Test classes should end with:

```text
Test
```

Examples:

```java
LoginTest
TransferTest
DashboardTest
AccountApiTest
RequirementAnalyzerTest
FailureAnalyzerTest
```

---

# 17. Test Method Naming

Test method names must describe the behavior being validated.

Preferred format:

```text
should[ExpectedBehavior]When[Condition]
```

Examples:

```java
shouldLoginSuccessfullyWhenValidCredentialsAreProvided()

shouldRejectLoginWhenInvalidPasswordIsProvided()

shouldBlockTransferWhenAccountBalanceIsInsufficient()

shouldGenerateTestCasesWhenValidRequirementIsProvided()
```

---

# 18. Avoid Generic Test Names

Avoid:

```java
testLogin()
testTransfer()
testCase1()
verifyLogin()
testSomething()
```

These names do not communicate business intent.

---

# 19. Negative Test Naming

Negative tests should clearly describe the invalid condition.

Examples:

```java
shouldRejectTransferWhenAmountIsZero()

shouldRejectLoginWhenPasswordIsInvalid()

shouldBlockUserAfterMaximumFailedLoginAttempts()

shouldRejectRequestWhenAuthenticationTokenIsMissing()
```

---

# 20. Boundary Test Naming

Boundary tests should communicate the boundary condition.

Examples:

```java
shouldAllowTransferWhenAmountEqualsDailyLimit()

shouldRejectTransferWhenAmountExceedsDailyLimit()

shouldAcceptOtpWhenEnteredWithinValidityPeriod()

shouldRejectOtpWhenItHasExpired()
```

---

# 21. API Class Naming

API clients should use the business resource name followed by `Api` or `Client`.

Examples:

```java
LoginApi
AccountApi
TransferApi
BeneficiaryApi
NotificationApi
```

Alternatively:

```java
LoginApiClient
AccountApiClient
TransferApiClient
```

The project will use one convention consistently once API implementation begins.

---

# 22. Page Object Naming

Page Objects must end with:

```text
Page
```

Examples:

```java
LoginPage
DashboardPage
TransferPage
BeneficiaryPage
ProfilePage
StatementPage
```

---

# 23. Service Naming

Business workflow classes should end with:

```text
Service
```

Examples:

```java
AuthenticationService
TransferService
AccountService
ProfileService
NotificationService
```

---

# 24. Factory Naming

Factory classes must end with:

```text
Factory
```

Examples:

```java
DriverFactory
BrowserFactory
AIProviderFactory
TestDataFactory
ApiClientFactory
```

---

# 25. Validator Naming

Validation classes should end with:

```text
Validator
```

Examples:

```java
UIValidator
APIValidator
AIResponseValidator
BusinessValidator
SchemaValidator
```

---

# 26. Utility Naming

Utility classes should end with:

```text
Utils
```

Examples:

```java
DateUtils
JsonUtils
FileUtils
ScreenshotUtils
WaitUtils
RandomDataUtils
```

Avoid creating a generic:

```java
Utils
Utility
Helper
```

class containing unrelated functionality.

---

# 27. AI Component Naming

AI classes should clearly communicate their responsibility.

Examples:

```java
RequirementAnalyzer
TestCaseGenerator
AutomationCodeGenerator
FailureAnalyzer
RootCauseAnalyzer
BugReportGenerator
RegressionRiskAnalyzer
ReleaseSummaryGenerator
```

Avoid vague names:

```java
AIHelper
AIUtil
AIManager
AIProcessor
AIEngine
```

unless the class genuinely represents that responsibility.

---

# 28. AI Prompt Naming

Prompt files should describe the task they perform.

Examples:

```text
analyze_requirement.md

generate_test_cases.md

generate_automation_code.md

analyze_failure.md

generate_bug_report.md

analyze_regression_risk.md

generate_release_summary.md
```

---

# 29. AI Provider Naming

Provider implementations should follow:

```text
[ProviderName]AIProvider
```

Examples:

```java
OpenAIProvider
AnthropicProvider
GeminiProvider
```

Interface:

```java
AIProvider
```

Factory:

```java
AIProviderFactory
```

This allows future providers to be added without changing consuming components.

---

# 30. Model Naming

AI request and response models should communicate their purpose.

Examples:

```java
RequirementAnalysisRequest
RequirementAnalysisResponse

TestCaseGenerationRequest
TestCaseGenerationResponse

FailureAnalysisRequest
FailureAnalysisResponse

BugReportRequest
BugReportResponse
```

---

# 31. DTO Naming

DTOs should end with:

```text
Request
Response
DTO
```

Examples:

```java
LoginRequest
LoginResponse
TransferRequest
TransferResponse
UserDTO
```

Use `DTO` only where it provides useful architectural clarity.

---

# 32. Exception Naming

Custom exceptions must end with:

```text
Exception
```

Examples:

```java
ConfigurationException
AIException
APIException
DriverException
ValidationException
FrameworkException
```

---

# 33. Listener Naming

Listeners should end with:

```text
Listener
```

Examples:

```java
TestListener
SuiteListener
RetryListener
ExecutionListener
```

---

# 34. Configuration File Naming

Use lowercase names with meaningful words.

Examples:

```text
config.properties

application.properties

log4j2.xml

testng.xml
```

Environment-specific files:

```text
application-dev.properties

application-qa.properties

application-stage.properties
```

---

# 35. JSON File Naming

Use lowercase `snake_case` for static test data.

Examples:

```text
valid_user.json

invalid_transfer.json

boundary_transaction.json
```

---

# 36. Test Data Naming

Test data should communicate its purpose.

Examples:

```text
valid_customer.json

invalid_customer.json

expired_otp.json

maximum_transfer_limit.json

insufficient_balance.json
```

---

# 37. Screenshot Naming

Screenshots should contain:

- Test name
- Timestamp
- Execution identifier

Example:

```text
shouldRejectInvalidLogin_20260808_102530.png
```

---

# 38. Report Naming

Reports should contain meaningful execution information.

Example:

```text
regression-report-20260808.html
```

---

# 39. Git Branch Naming

Branches should follow:

```text
<type>/<short-description>
```

Examples:

```text
feature/ai-requirement-analyzer

feature/test-case-generator

feature/failure-analysis

bugfix/login-test-failure

hotfix/configuration-issue

docs/framework-design
```

---

# 40. Git Commit Naming

Commits should follow Conventional Commits.

Format:

```text
type(scope): description
```

Examples:

```text
feat(ai): add requirement analyzer

feat(api): add transfer api client

test(ui): add login validation tests

fix(driver): resolve parallel execution issue

docs(framework): update architecture documentation

refactor(config): simplify environment configuration

chore(build): update maven dependencies
```

---

# 41. Git Tag Naming

Release tags should follow semantic versioning.

Examples:

```text
v1.0.0
v1.1.0
v2.0.0
```

---

# 42. Documentation Naming

Markdown documentation should use uppercase snake case when representing major framework documents.

Examples:

```text
FRAMEWORK_DESIGN.md

PACKAGE_STRUCTURE.md

NAMING_CONVENTIONS.md

CODING_STANDARDS.md

BUSINESS_REQUIREMENTS.md
```

Operational or prompt files may use lowercase naming where appropriate.

---

# 43. Environment Naming

Use standard environment identifiers:

```text
DEV
QA
STAGE
PROD
```

Avoid inconsistent names such as:

```text
development
testing
staging_environment
production_environment
```

unless required by an external system.

---

# 44. Browser Naming

Use standard browser identifiers:

```java
CHROME
FIREFOX
EDGE
SAFARI
```

---

# 45. User Role Naming

Use domain terminology.

```java
CUSTOMER
SUPPORT_AGENT
ADMIN
```

Avoid:

```java
USER1
USER2
ADMIN_USER
```

unless those represent actual application roles.

---

# 46. Naming Rules for AI-Generated Code

AI-generated code must follow the same naming standards as manually written code.

AI assistance does not exempt generated code from:

- Naming conventions
- Code review
- Static analysis
- Security review
- Test coverage
- Maintainability standards

Generated code must be reviewed before being merged.

---

# 47. Naming Checklist

Before creating a class, method, or variable, ask:

1. Does the name communicate intent?
2. Is it consistent with the domain?
3. Does it follow Java conventions?
4. Is it searchable?
5. Can another engineer understand it without reading the implementation?
6. Does it avoid unnecessary abbreviations?
7. Does it follow the project's existing terminology?
8. Would an AI coding assistant understand its purpose?

---

# 48. Quick Reference

| Element | Convention | Example |
|---|---|---|
| Package | lowercase | `com.tanvi.qa.ai` |
| Class | PascalCase | `LoginPage` |
| Interface | PascalCase | `AIProvider` |
| Method | camelCase | `login()` |
| Variable | camelCase | `accountNumber` |
| Constant | UPPER_SNAKE_CASE | `MAX_RETRY_COUNT` |
| Enum | PascalCase | `BrowserType` |
| Enum Value | UPPER_SNAKE_CASE | `CHROME` |
| Test Class | PascalCase + Test | `LoginTest` |
| Test Method | Behavior-based | `shouldLoginSuccessfullyWhenValidCredentialsAreProvided()` |
| Factory | PascalCase + Factory | `DriverFactory` |
| Service | PascalCase + Service | `TransferService` |
| Validator | PascalCase + Validator | `APIValidator` |
| Utility | PascalCase + Utils | `DateUtils` |
| Exception | PascalCase + Exception | `AIException` |
| Listener | PascalCase + Listener | `TestListener` |
| Git Branch | type/description | `feature/ai-test-generator` |
| Git Commit | Conventional Commit | `feat(ai): add test generator` |

---

# 49. Conclusion

Consistent naming is a fundamental part of building a maintainable enterprise automation framework.

The naming conventions defined in this document ensure that the AI-Assisted Quality Engineering Platform remains understandable to human engineers, automation engineers, architects, code reviewers, and AI-assisted development tools.

All new code should follow these conventions.

Any deviation should have a clear technical justification and should be documented during code review.