# AI-Assisted Quality Engineering Platform

# CODING_STANDARDS.md

**Version:** 1.0  
**Project:** AI-Assisted Quality Engineering Platform  
**Language:** Java 21  
**Build Tool:** Maven  
**Primary IDE:** Visual Studio Code  

---

# 1. Purpose

This document defines the coding standards for the AI-Assisted Quality Engineering Platform.

The objective is to ensure that the codebase remains:

- Clean
- Readable
- Maintainable
- Testable
- Secure
- Scalable
- Consistent
- Reviewable

These standards apply to:

- Framework code
- UI automation
- API automation
- AI integration
- Utilities
- Test code
- Configuration
- Reporting
- CI/CD code

---

# 2. Core Engineering Principles

The framework follows these principles:

## SOLID

All production code should follow SOLID principles wherever applicable.

---

## DRY

Avoid duplicate code.

Common functionality should be extracted into reusable components.

---

## KISS

Avoid unnecessary complexity.

The simplest solution that satisfies the requirement should be preferred.

---

## YAGNI

Do not implement functionality merely because it may be useful someday.

---

## Separation of Concerns

Each component must have one clearly defined responsibility.

---

# 3. Java Version

The project uses:

```text
Java 21
```

Developers must not introduce APIs that require a newer Java version unless the project version is formally upgraded.

---

# 4. Indentation

Use:

```text
4 spaces
```

for Java indentation.

Do not use tabs for Java source code.

Example:

```java
public void login() {
    enterUserName();
    enterPassword();
    clickLogin();
}
```

---

# 5. Line Length

Prefer lines below:

```text
120 characters
```

Long statements should be broken into multiple lines when doing so improves readability.

---

# 6. Braces

Always use braces for control structures.

## Correct

```java
if (isLoggedIn()) {
    navigateToDashboard();
}
```

## Incorrect

```java
if (isLoggedIn())
    navigateToDashboard();
```

Even for one-line statements, braces should be used.

---

# 7. Class Design

Classes should have a single responsibility.

## Good

```java
LoginPage
```

Responsible for login-page interactions.

## Bad

```java
TestUtils
```

containing:

- Browser logic
- API logic
- Database logic
- Screenshot logic
- AI logic

---

# 8. Method Size

Methods should generally remain small and focused.

Prefer:

```java
login()
```

calling:

```java
enterUserName()

enterPassword()

clickLogin()
```

instead of placing all logic in one large method.

Large methods should be refactored when they contain multiple independent responsibilities.

---

# 9. Method Parameters

Avoid excessive parameters.

Instead of:

```java
createUser(
    String name,
    String email,
    String phone,
    String address,
    String city,
    String country
);
```

prefer a model:

```java
createUser(User user);
```

---

# 10. Null Handling

Avoid unnecessary null values.

Prefer:

- Validation
- Optional where appropriate
- Defensive programming
- Meaningful exceptions

Do not silently ignore null values.

---

# 11. Exception Handling

Never use empty catch blocks.

## Incorrect

```java
try {
    login();
} catch (Exception e) {
}
```

## Correct

```java
try {
    login();
} catch (AuthenticationException e) {
    logger.error("Authentication failed for user: {}", userName, e);
    throw e;
}
```

---

# 12. Exception Types

Catch the most specific exception possible.

Avoid:

```java
catch (Exception e)
```

unless there is a justified framework-level reason.

Prefer:

```java
catch (TimeoutException e)
```

or:

```java
catch (IOException e)
```

---

# 13. Logging

Use Log4j2 for framework logging.

Do not use:

```java
System.out.println()
```

in production framework code.

Use:

```java
logger.info("Starting login flow");
logger.debug("Using environment: {}", environment);
logger.warn("Retrying failed operation");
logger.error("API request failed", exception);
```

---

# 14. Logging Sensitive Information

Never log:

- Passwords
- Authentication tokens
- API keys
- Credit card numbers
- Personal secrets
- Production credentials

Instead:

```java
logger.info("Authentication request submitted for user: {}", maskedUserName);
```

---

# 15. Constants

Avoid magic numbers and strings.

## Bad

```java
Thread.sleep(5000);
```

## Better

```java
Thread.sleep(DEFAULT_WAIT_TIME);
```

However, explicit waits should be preferred over `Thread.sleep()` in UI automation.

---

# 16. Configuration

Configuration values must not be hardcoded in Java classes.

## Bad

```java
String baseUrl = "https://qa.neobank.com";
```

## Better

```java
String baseUrl = config.getBaseUrl();
```

Environment-specific values should be stored in configuration files or environment variables.

---

# 17. Secrets Management

Never commit secrets to GitHub.

Never store:

```text
API keys
Passwords
Tokens
Private keys
Cloud credentials
```

in source code.

Use:

- Environment variables
- GitHub Secrets
- Secret managers
- Local `.env` files excluded through `.gitignore`

---

# 18. Page Object Model Standards

Page Objects should contain:

- Locators
- Page actions
- Page-specific behavior

Page Objects should not contain:

- Test assertions
- Test data
- Business orchestration
- Reporting logic

---

# 19. Assertions

Assertions should primarily exist in test or validation layers.

Example:

```java
assertEquals(
    dashboardPage.getAccountBalance(),
    expectedBalance
);
```

Avoid embedding test assertions inside generic Page Objects.

---

# 20. Test Independence

Tests should be independently executable whenever practical.

A test should not rely on another test having executed before it.

Avoid:

```text
Test A creates user

↓

Test B depends on Test A

↓

Test C depends on Test B
```

Prefer independent setup and cleanup.

---

# 21. Test Data

Test data should be separated from test logic.

Use:

- JSON
- Properties
- Builders
- Factories
- Database fixtures
- API setup

Avoid hardcoding large datasets inside test methods.

---

# 22. Test Design

Tests should validate behavior, not implementation details.

Prefer:

```java
shouldRejectTransferWhenBalanceIsInsufficient()
```

rather than:

```java
shouldClickTransferButton()
```

The first validates business behavior.

---

# 23. Test Independence and Cleanup

Tests that create data should clean up after execution when appropriate.

Example:

```text
Create Customer

↓

Execute Test

↓

Delete Customer
```

Where cleanup is impossible, use unique test data and document the strategy.

---

# 24. UI Automation Standards

Avoid hard waits.

## Never prefer

```java
Thread.sleep(5000);
```

Use:

```java
WebDriverWait
```

or Selenium's appropriate explicit waiting mechanisms.

---

# 25. Locator Strategy

Prefer stable locators.

Recommended priority:

1. `data-testid`
2. Accessibility attributes
3. Stable IDs
4. Name attributes
5. Stable CSS selectors
6. XPath when necessary

Avoid fragile locators based on:

- Dynamic generated IDs
- Position
- Deep DOM hierarchy
- CSS classes that frequently change

---

# 26. API Testing Standards

API tests should validate:

- Status code
- Response body
- Headers
- Schema
- Business rules
- Authentication
- Authorization

Example:

```java
given()
    .auth()
    .oauth2(token)
.when()
    .get("/accounts")
.then()
    .statusCode(200)
    .body("status", equalTo("ACTIVE"));
```

---

# 27. API Test Data

API payloads should preferably be created using:

- POJOs
- Builders
- JSON fixtures

Avoid manually concatenating JSON strings.

Bad:

```java
String body = "{\"name\":\"Tanvi\",\"age\":36}";
```

Prefer:

```java
UserRequest request = UserRequest.builder()
    .name("Test User")
    .build();
```

---

# 28. AI Coding Standards

AI-generated code is treated exactly like manually written code.

AI-generated code must pass:

- Code review
- Compilation
- Unit tests
- Integration tests
- Static analysis
- Security review
- Architecture review

AI-generated code must never be blindly committed.

---

# 29. AI Prompt Standards

Prompts should be:

- Version controlled
- Reusable
- Specific
- Structured
- Testable

Prompts should define:

- Role
- Context
- Input
- Expected output
- Constraints
- Quality criteria

Example:

```text
You are a senior QA engineer.

Analyze the following requirement.

Identify:
1. Functional scenarios
2. Negative scenarios
3. Boundary scenarios
4. Security risks
5. Accessibility risks

Return the result as structured JSON.
```

---

# 30. AI Response Validation

Never assume that an AI response is correct.

AI outputs must be validated for:

- Schema
- Required fields
- Data types
- Business rules
- Hallucinations
- Duplicates
- Missing scenarios

Example flow:

```text
LLM Response

↓

JSON Validation

↓

Business Rule Validation

↓

Duplicate Detection

↓

Human Review

↓

Approved Output
```

---

# 31. AI Hallucination Handling

AI-generated output should be treated as probabilistic.

The framework should:

- Validate generated data.
- Detect unsupported assumptions.
- Flag uncertain responses.
- Use confidence scores where appropriate.
- Maintain human approval for high-impact decisions.

AI must not make uncontrolled production decisions.

---

# 32. AI Provider Abstraction

AI integrations should use an abstraction.

Example:

```java
public interface AIProvider {

    AIResponse generate(AIPrompt prompt);
}
```

Implementations may include:

```java
OpenAIProvider

GeminiProvider

AnthropicProvider
```

This prevents the framework from becoming tightly coupled to one AI vendor.

---

# 33. Retry Strategy

Retries should be used carefully.

Retry only when failures may be transient.

Examples:

- Network timeout
- Temporary service unavailable
- Browser startup failure

Do not retry assertion failures blindly.

Incorrect:

```text
Test failed

↓

Retry 3 times

↓

Pass

↓

Mark as Passed
```

This can hide genuine defects.

---

# 34. Flaky Test Management

Flaky tests must be identified rather than permanently hidden.

The framework should capture:

- Failure frequency
- Previous result
- Retry result
- Execution duration
- Error category

Future AI functionality will analyze these patterns.

---

# 35. Thread Safety

Framework components used in parallel execution must be thread-safe.

WebDriver instances should not be shared across test threads.

Recommended approach:

```java
ThreadLocal<WebDriver>
```

or an equivalent driver management strategy.

---

# 36. Resource Management

External resources must be properly closed.

Examples:

- Files
- Streams
- Database connections
- HTTP clients

Prefer:

```java
try-with-resources
```

where applicable.

---

# 37. Immutability

Prefer immutable objects for configuration and request models where practical.

Use:

```java
final
```

where appropriate.

Avoid unnecessary mutable shared state.

---

# 38. Dependency Management

Dependencies must be:

- Required
- Version controlled
- Regularly reviewed
- Free of known critical vulnerabilities

Avoid adding libraries without a clear purpose.

---

# 39. Maven Standards

Maven dependencies should be organized logically.

Recommended sections:

```xml
<properties>

<dependencies>

<build>

<plugins>
```

Use Maven properties for dependency versions where appropriate.

Example:

```xml
<properties>
    <java.version>21</java.version>
    <selenium.version>...</selenium.version>
</properties>
```

---

# 40. Static Analysis

The project should progressively integrate:

- Checkstyle
- SpotBugs
- OWASP Dependency Check
- SonarQube

Static analysis should be part of CI/CD.

---

# 41. Code Formatting

The project should use a consistent formatter.

Formatting should be automated wherever possible.

Developers should not rely solely on manual formatting.

---

# 42. Comments

Comments should explain **why**, not simply **what**.

Bad:

```java
// Click login button
loginButton.click();
```

Good:

```java
// The login button becomes enabled only after client-side validation completes.
wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
```

Avoid excessive comments.

Clean code should communicate intent naturally.

---

# 43. TODO Usage

TODO comments should be used sparingly.

Good:

```java
// TODO: Replace local file storage with centralized artifact storage.
```

Avoid:

```java
// TODO: Fix this
```

Every significant TODO should ideally correspond to a GitHub Issue.

---

# 44. Assertions and Error Messages

Assertions should provide useful failure information.

Prefer:

```java
assertEquals(
    actualBalance,
    expectedBalance,
    "Account balance did not match expected value"
);
```

Avoid:

```java
assertEquals(actualBalance, expectedBalance);
```

when the failure message would significantly improve debugging.

---

# 45. Code Review Standards

Every Pull Request should verify:

- Naming conventions
- SOLID principles
- Test coverage
- Error handling
- Logging
- Security
- Duplicate code
- Performance
- AI-generated code quality
- Documentation

---

# 46. Pull Request Standards

Pull Requests should contain:

## Summary

What was implemented?

## Changes

What files/components changed?

## Testing

What tests were executed?

## Risks

Are there any known risks?

## Screenshots / Reports

Attach when relevant.

---

# 47. Commit Standards

Use Conventional Commits.

Examples:

```text
feat(ai): add requirement analyzer

test(api): add transfer api tests

fix(driver): handle browser initialization failure

refactor(config): improve environment configuration

docs(ai): document prompt engineering strategy

chore(ci): configure github actions
```

---

# 48. Definition of Done

A feature is considered complete only when:

- Code is implemented.
- Unit tests are added where applicable.
- Automation tests are added where applicable.
- Error handling exists.
- Logging exists.
- Documentation is updated.
- Code follows naming standards.
- Static analysis passes.
- Tests pass locally.
- CI passes.
- Pull Request review is complete.

---

# 49. Definition of Done for AI Features

AI features require additional checks.

A feature is complete only when:

- Prompt is version controlled.
- Input schema is defined.
- Output schema is defined.
- AI response is validated.
- Hallucination risks are documented.
- Failure handling exists.
- Retry strategy is defined.
- Token usage is considered.
- Sensitive data handling is reviewed.
- Sample inputs and outputs are documented.
- Human review requirements are documented.

---

# 50. Security Standards

Never commit:

```text
API keys
Passwords
Tokens
Private certificates
Production credentials
Customer data
```

Sensitive data must be masked in:

- Logs
- Reports
- Screenshots
- AI prompts
- AI responses

---

# 51. Performance Standards

Automation code should avoid unnecessary operations.

Examples:

- Avoid repeated login when session reuse is safe.
- Avoid unnecessary browser creation.
- Avoid excessive API calls.
- Avoid unnecessary waits.
- Prefer direct API setup for test data where appropriate.

---

# 52. Maintainability Standards

Code should be easy for another engineer to understand.

Before adding code, ask:

1. Does this functionality already exist?
2. Can it be reused?
3. Is this the correct package?
4. Does the class have one responsibility?
5. Can the method be simplified?
6. Is the error handling adequate?
7. Can the code be tested independently?

---

# 53. Test Automation Pyramid

The framework should follow a balanced testing strategy.

```text
             UI Tests
             ▲
            / \
           /   \
          /     \
       API Tests
        ▲
       / \
      /   \
 Unit / Integration
 Tests
```

Prefer more lower-level tests and fewer expensive UI tests.

---

# 54. Quality Gates

Future CI/CD pipelines should enforce:

```text
Compile
   ↓
Unit Tests
   ↓
Static Analysis
   ↓
API Tests
   ↓
UI Smoke Tests
   ↓
AI Validation
   ↓
Reports
```

A build should fail when critical quality gates fail.

---

# 55. Documentation Standards

Every major framework component should have documentation covering:

- Purpose
- Architecture
- Usage
- Configuration
- Examples
- Limitations
- Troubleshooting

---

# 56. Observability

Future framework versions should capture:

- Test execution duration
- API latency
- AI response latency
- Token usage
- Retry counts
- Failure categories
- Flaky test frequency

These metrics will support future AI-driven quality analytics.

---

# 57. AI Cost Management

AI calls can introduce operational costs.

The framework should consider:

- Token usage
- Model selection
- Prompt size
- Response size
- Caching
- Retry limits
- Batch processing

Expensive models should not be used when a smaller model can provide equivalent results.

---

# 58. AI Model Configuration

AI model configuration should not be hardcoded.

Example:

```text
AI_PROVIDER=OPENAI
AI_MODEL=<configured-model>
AI_TEMPERATURE=<configured-value>
AI_MAX_TOKENS=<configured-value>
```

The actual secrets must be supplied through environment variables or secure secret storage.

---

# 59. Human-in-the-Loop Principle

AI recommendations should not automatically become production decisions.

Critical workflow:

```text
AI Recommendation

↓

Validation

↓

Human Review

↓

Approval

↓

Execution
```

This principle is particularly important for:

- Defect severity
- Release recommendations
- Security findings
- Production-impacting decisions

---

# 60. Final Coding Checklist

Before committing code:

- [ ] Code compiles.
- [ ] Tests pass.
- [ ] Naming conventions are followed.
- [ ] No unnecessary duplication exists.
- [ ] No hardcoded secrets exist.
- [ ] Logging is appropriate.
- [ ] Exceptions are handled.
- [ ] No `System.out.println()` exists in framework code.
- [ ] No unnecessary `Thread.sleep()` exists.
- [ ] Test data is separated from test logic.
- [ ] Documentation is updated.
- [ ] AI-generated code has been reviewed.
- [ ] Static analysis passes.
- [ ] Git commit follows Conventional Commits.

---

# 61. Conclusion

The AI-Assisted Quality Engineering Platform follows modern software engineering and Quality Engineering practices rather than treating automation as a collection of scripts.

These coding standards establish a consistent engineering culture across:

- Java development
- UI automation
- API automation
- AI integration
- Test engineering
- CI/CD
- Reporting
- Security
- Observability

The standards are intentionally designed to support the long-term evolution of the framework from a test automation project into an enterprise-grade AI-assisted Quality Engineering platform.

All contributors, including AI-assisted development tools, are expected to follow these standards.