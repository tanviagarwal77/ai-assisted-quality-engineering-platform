# Business Rules

## Document Information

| Property      | Value                                              |
| ------------- | -------------------------------------------------- |
| Project       | NeoBank – AI Assisted Quality Engineering Platform |
| Document Type | Business Rules Specification (BRS)                 |
| Version       | 1.0                                                |
| Status        | Draft                                              |
| Owner         | Business Analysis Team                             |
| Prepared By   | Quality Engineering Team                           |

---

# Purpose

This document defines the business rules governing the NeoBank Digital Banking Platform. Business rules represent the policies, constraints, validations, and operational conditions that the application must enforce to ensure secure, compliant, and consistent banking operations.

These rules serve as the foundation for:

* Functional implementation
* Acceptance criteria
* Manual testing
* Automation testing
* API validation
* AI-assisted test generation
* Regression testing
* Risk analysis

---

# Business Rules

---

## BRULE-001 – Customer Age Eligibility

A customer must be at least **18 years old** to register for an online banking account.

**Reason**

Legal compliance.

---

## BRULE-002 – Unique Customer Registration

A mobile number and email address may only be associated with one active customer account.

**Reason**

Prevent duplicate customer records.

---

## BRULE-003 – Mandatory KYC Verification

Customers must successfully complete Know Your Customer (KYC) verification before activating their banking account.

**Reason**

Regulatory compliance.

---

## BRULE-004 – Password Complexity

Passwords must:

* Be at least 8 characters long
* Contain one uppercase letter
* Contain one lowercase letter
* Contain one numeric digit
* Contain one special character

**Reason**

Improve account security.

---

## BRULE-005 – OTP Validity

One-Time Passwords (OTP) shall remain valid for **5 minutes**.

Expired OTPs shall not be accepted.

**Reason**

Reduce unauthorized access.

---

## BRULE-006 – Maximum OTP Attempts

Customers may enter an incorrect OTP a maximum of **three times**.

After the third failure, a new OTP must be generated.

---

## BRULE-007 – Login Attempt Limit

Customer accounts shall be temporarily locked after **three consecutive failed login attempts**.

---

## BRULE-008 – Session Timeout

User sessions shall automatically expire after **15 minutes of inactivity**.

---

## BRULE-009 – Single Active Session

A customer may have only one active authenticated web session at a time.

A new login shall invalidate the previous session.

---

## BRULE-010 – Beneficiary Activation Delay

A newly added beneficiary shall become eligible for fund transfers only after a **30-minute cooling period** following successful OTP verification.

---

## BRULE-011 – Beneficiary Verification

Beneficiary account number and IFSC code shall be validated before activation.

---

## BRULE-012 – Minimum Fund Transfer Amount

The minimum transfer amount shall be **₹1**.

Transfers below this amount shall be rejected.

---

## BRULE-013 – Maximum Daily Transfer Limit

A customer shall not transfer more than **₹5,00,000** per calendar day.

---

## BRULE-014 – Account Balance Validation

Fund transfers shall be permitted only if the available balance is greater than or equal to:

Transfer Amount + Applicable Charges

---

## BRULE-015 – Duplicate Transaction Prevention

The system shall prevent duplicate financial transactions submitted within a short interval using the same request identifier.

---

## BRULE-016 – Failed Transaction Rollback

If a transfer fails during processing, all financial updates shall be rolled back to maintain data consistency.

---

## BRULE-017 – Transaction Reference Number

Every successful financial transaction shall generate a unique transaction reference number.

Reference numbers shall never be reused.

---

## BRULE-018 – Statement Generation

Customers may generate account statements for any date range not exceeding **12 months** in a single request.

---

## BRULE-019 – Profile Update Verification

Changes to:

* Mobile Number
* Email Address

shall require OTP verification before becoming effective.

---

## BRULE-020 – Debit Card Blocking

A blocked debit card shall immediately reject:

* ATM Withdrawals
* POS Transactions
* Online Payments
* Contactless Payments

until unblocked by the customer.

---

## BRULE-021 – Role-Based Access Control (RBAC)

Users shall access only the features permitted by their assigned role.

No user shall perform operations outside their authorization.

---

## BRULE-022 – Audit Logging

The following activities shall always generate audit records:

* Login
* Logout
* Password Change
* Profile Update
* Fund Transfer
* Beneficiary Changes
* Administrative Actions

Audit logs shall not be editable.

---

## BRULE-023 – Notification Generation

Customers shall receive notifications for:

* Successful Login
* Failed Login
* Password Change
* OTP Generation
* Fund Transfer
* Beneficiary Addition
* Profile Update

Notifications shall be delivered through configured communication channels.

---

## BRULE-024 – Fraud Detection

The system shall flag suspicious activities including:

* Multiple failed logins
* Login from unknown device
* Large transfer amount
* Rapid consecutive transfers
* Multiple OTP requests
* Login from geographically unusual locations

Flagged activities shall be available for review.

---

## BRULE-025 – Customer Support Restrictions

Customer Support Executives may:

* View customer information
* Unlock customer accounts
* Reset passwords after verification

Customer Support shall not:

* Transfer customer funds
* Modify balances
* Approve transactions

---

## BRULE-026 – Administrator Restrictions

Administrators may configure system settings but shall not:

* View customer passwords
* Access encryption keys
* Perform customer financial transactions

---

## BRULE-027 – Sensitive Data Masking

The following information shall always be masked when displayed:

* Account Number
* Debit Card Number
* CVV
* Government Identification Number

Only authorized users may view partially masked values.

---

## BRULE-028 – AI Output Approval

AI-generated artifacts including:

* Test Cases
* Automation Code
* Bug Reports
* Root Cause Analysis
* Release Recommendations

must be reviewed and approved by a Quality Engineer before use in production workflows.

---

## BRULE-029 – Regulatory Compliance

Customer financial records, transaction history, and audit logs shall be retained according to applicable banking and regulatory retention policies.

---

## BRULE-030 – System Availability

During scheduled maintenance windows:

* Financial transactions shall be temporarily disabled.
* Customers shall be informed through maintenance notifications.
* Read-only services such as statement viewing may remain available where applicable.

---

# Business Rule Traceability Matrix

| Business Rule          | Related Functional Area         |
| ---------------------- | ------------------------------- |
| BRULE-001 to BRULE-004 | Registration & Authentication   |
| BRULE-005 to BRULE-009 | Security & Session Management   |
| BRULE-010 to BRULE-017 | Beneficiaries & Fund Transfers  |
| BRULE-018              | Statements                      |
| BRULE-019              | Profile Management              |
| BRULE-020              | Debit Card Management           |
| BRULE-021              | Authorization                   |
| BRULE-022              | Audit Logging                   |
| BRULE-023              | Notifications                   |
| BRULE-024              | Fraud Detection                 |
| BRULE-025              | Customer Support                |
| BRULE-026              | Administration                  |
| BRULE-027              | Data Privacy                    |
| BRULE-028              | AI-Assisted Quality Engineering |
| BRULE-029              | Regulatory Compliance           |
| BRULE-030              | Operational Availability        |

---

# Quality Engineering Considerations

These business rules will be validated through multiple testing strategies:

### Functional Testing

* Positive and negative scenarios
* Boundary value analysis
* Decision table testing
* Equivalence partitioning

### API Testing

* Request validation
* Authorization
* Business rule enforcement
* Error handling

### UI Automation

* Registration
* Login
* Fund Transfer
* Beneficiary Management
* Profile Updates
* Notifications

### Security Testing

* Authentication
* Authorization
* Session Management
* Data Masking
* Input Validation

### Performance Testing

* Concurrent fund transfers
* Dashboard loading
* Statement generation
* Session handling

### AI-Assisted Quality Engineering

Business rules defined in this document will be used by AI modules to:

* Detect missing validations
* Generate positive and negative test cases
* Suggest edge cases
* Perform regression impact analysis
* Validate requirement completeness
* Identify high-risk business scenarios

---

# Conclusion

The business rules documented here establish the operational constraints and validation logic required for NeoBank. Together with the Business Requirements, Functional Requirements, and Non-Functional Requirements, these rules provide complete traceability from business intent through implementation and testing, ensuring a robust foundation for enterprise-grade quality engineering.
