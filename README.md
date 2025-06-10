# FinAltica Pro

---

## 🚀 Overview

**FinAltica Pro** is a comprehensive, full-stack financial management system built using:

- **Backend**: Spring Boot (Java), PostgreSQL  
- **Frontend**: React.js, Redux, TailwindCSS, Chart.js/D3.js  

FinAltica Pro is designed for both individual users and small businesses to:

1. **Aggregate** multiple bank accounts, credit cards, and investment portfolios  
2. **Manage** multi-currency transactions with automatic exchange-rate updates  
3. **Alert** users when category spending exceeds predefined limits (rule-based)  
4. **Schedule** bill and subscription reminders with email/SMS notifications  
5. **Automate** recurring transactions (rent, utilities, subscriptions) in a daily job  
6. **Provide** a full undo/redo audit trail for every transaction or category change  
7. **Render** interactive dashboards—spending trends, cash-flow forecasts, and portfolio snapshots  
8. **Log** every user action to an immutable AuditLog table for compliance  
9. **Export** monthly statements and budget summaries to PDF or Excel  

---

## 🎯 Key Features

### 1. User & Authentication
- **Registration & Login**  
- JWT-based stateless authentication (USER and ADMIN roles)  
- Secure password hashing (BCrypt)

### 2. Multi-Account Aggregation
- Create and manage Bank, Credit Card, and Investment accounts  
- Store balances in different currencies  

### 3. Transaction Management
- Add/Edit/Delete transactions (one-time or recurring)  
- Recurring transactions engine (daily scheduled task)  
- View transactions by date range, category, or account  

### 4. Rule-Based Alerts & Overspending Notifications
- Define category-level spending limits (Daily, Weekly, Monthly)  
- On each new transaction, check against alert rules  
- Send email/SMS notification when an alert is triggered  
- View and resolve active alerts in a dedicated UI section

### 5. Bill & Subscription Reminders
- Create one-time or recurring bill reminders (e.g., rent, utilities)  
- Scheduled task to send notifications on due dates  
- Automatically update next due date for recurring reminders  
- View upcoming bills in a calendar or list

### 6. Undo/Redo Audit Trail
- Stack-based in-memory undo/redo system for every create/update/delete action  
- Persist each action’s before/after snapshot in an `audit_logs` table (JSONB)  
- Endpoints to undo or redo the last action in under   
- Complete chronological audit history for compliance

### 7. Investment Portfolio Snapshot
- Add investments (ticker, shares, purchase price, purchase date)  
- Fetch live prices from an external API to compute current value  
- Display table of holdings with profit/loss percentages  
- Pie chart breakdown of asset allocation

### 8. Interactive Dashboards & Reports
- Spending vs. Income line chart 
- Top Categories bar chart 
- Export functionality: generate PDF or Excel for monthly statements and budget summaries

### 9. Secure Role-Based Access
- USER role can only access their own accounts, transactions, and preferences  
- All REST API routes protected by Spring Security (JWT + Role filters)

---

## 📦 Tech Stack

- **Backend**  
  - Spring Boot 
  - Spring Security (JWT)  
  - Spring Data JPA (Hibernate)  
  - PostgreSQL 14+  
  - Jackson (JSON serialization)  
  - JavaMail (SMTP) & Twilio (SMS)  
  - Apache POI (Excel) & iText (PDF)  
  - Testcontainers (Integration Tests)

- **Frontend**  
  - React.js  & React Router
  - Redux Toolkit (state management)  
  - Axios (HTTP client)  
  - Tailwind CSS (styling)  
  - Chart.js & react-chartjs (charts)  
  - D3.js (custom visualizations)  
  - React Table (data grids)  


---

## Class Diagram

```mermaid

---

title: FinAlticaPro

---

classDiagram
    %% User Management
    class User {
        <<entity>>
        -userId: Long
        -firstName: String
        -lastName: String
        -username: String
        -email: String
        -password: String
        -role: String
        -bankAccounts: List<BankAccount>
        -creditCardAccounts: List<CreditCardAccounts>
        -investmentAccounts: List<InvestmentAccounts>
    }

    class BankAccount {
        <<entity>>
        -accountId: Long
        -user: User
        -bankName: String
        -accountNumber: String
        -accountType: String
        -balance: BigDecimal
        -currencyType: String
        -totalSpent: BigDecimal
        -createdAt: LocalDateTime
        -updatedAt: LocalDateTime
        
    }

    class CreditCardAccount {
        <<entity>>
        -creditCardId: Long
        -userId: Long
        -cardName: String
        -currentBalance: BigDecimal
        -creditLimit: BigDecimal
        -availableCredit: Long
        -interestRate: Double
        -currency: String
        -createdAt: LocalDateTime
        -updatedAt: LocalDateTime
    }

    class InvestmentAccount {
        <<entity>>
        -investmentId: Long
        -user: User
        -brokerName: String
        -totalValueInvested: BigDecimal
        -currency: String
        -createdAt: LocalDateTime
        -updatedAt: LocalDateTime
    }

    %% Payment Method Interface and Implementations
    class PaymentMethod {
        <<interface>>
        +getPaymentMethodType(): String
        +getLinkedAccountId(): Long
        +isActive(): Boolean
    }

    class DebitCard {
        <<entity>>
        -debitCardId: Long
        -userId: Long
        -cardNumber: String
        -cardName: String
        -linkedBankAccountId: Long
        -totalSpent: Long
        -isActive: Boolean
        +processPayment(amount: Long): Boolean
    }

    class CreditCard {
        <<entity>>
        -creditCardId: Long
        -userId: Long
        -cardNumber: String
        -cardName: String
        -linkedCreditAccountId: Long
        -totalSpent: Long
        -monthlySpent: Long
        -isActive: Boolean
        +processPayment(amount: Long): Boolean
        +calculateMonthlySpending(): Long
    }

    class OnlineTransfer {
        <<entity>>
        -onlineTransferId: Long
        -userId: Long
        -transferMethod: String
        -linkedAccountId: Long
        -totalTransactions: Long
        +initiateTransfer(amount: Long): Boolean
    }

    class CashPayment {
        <<entity>>
        -cashPaymentId: Long
        -userId: Long
        -totalCashSpent: Long
        +recordCashPayment(amount: Long): void
    }

    %% Transaction Management
    class Transaction {
        <<entity>>
        -transactionId: Long
        -userId: Long
        -amount: Long
        -transactionType: String
        -paymentMethodType: String
        -paymentMethodId: Long
        -linkedAccountId: Long
        -category: String
        -description: String
        -transactionDate: LocalDateTime
        -fromAccount: String
        -toAccount: String
        -currency: String
        -isRecurring: Boolean
        +createTransaction(): Transaction
        +validateTransaction(): Boolean
        +updateAccountBalances(): void
    }

    class RecurringTransaction {
        <<entity>>
        -recurringId: Long
        -userId: Long
        -templateTransactionId: Long
        -frequency: String
        -nextExecutionDate: LocalDate
        -isActive: Boolean
        +scheduleNext(): void
        +executeRecurring(): void
    }

    %% Investment Tracking
    class Investment {
        <<entity>>
        -investmentId: Long
        -userId: Long
        -investmentAccountId: Long
        -ticker: String
        -shares: Double
        -purchasePrice: Double
        -purchaseDate: LocalDate
        -currentPrice: Double
        -totalValue: Double
        +calculateCurrentValue(): Double
        +calculateProfitLoss(): Double
    }

    %% Category Management
    class Category {
        <<entity>>
        -categoryId: Long
        -userId: Long
        -categoryName: String
        -budgetLimit: Long
        -currentSpent: Long
        -alertThreshold: Double
        +checkBudgetAlert(): Boolean
    }

   

    PaymentMethod <|.. DebitCard
    PaymentMethod <|.. CreditCard
    PaymentMethod <|.. OnlineTransfer
    PaymentMethod <|.. CashPayment

    