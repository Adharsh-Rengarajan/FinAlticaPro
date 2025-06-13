package com.finalticapro.application.entities.transaction;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "recurring_transactions")
public class RecurringTransaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recurring_id")
    private Long recurringId;
    
    @Column(name = "user_id", nullable = false)
    private Long userId;
    
    @Column(name = "template_transaction_id", nullable = false)
    private Long templateTransactionId;
    
    @Column(name = "frequency", nullable = false)
    private String frequency;
    
    @Column(name = "next_execution_date", nullable = false)
    private LocalDate nextExecutionDate;
    
    @Column(name = "is_active")
    private boolean isActive;
    
    public RecurringTransaction() {}
    
    public RecurringTransaction(Long recurringId, Long userId, Long templateTransactionId, String frequency,
            LocalDate nextExecutionDate, boolean isActive) {
        this.recurringId = recurringId;
        this.userId = userId;
        this.templateTransactionId = templateTransactionId;
        this.frequency = frequency;
        this.nextExecutionDate = nextExecutionDate;
        this.isActive = isActive;
    }
    
    public Long getRecurringId() {
        return recurringId;
    }
    
    public void setRecurringId(Long recurringId) {
        this.recurringId = recurringId;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public Long getTemplateTransactionId() {
        return templateTransactionId;
    }
    
    public void setTemplateTransactionId(Long templateTransactionId) {
        this.templateTransactionId = templateTransactionId;
    }
    
    public String getFrequency() {
        return frequency;
    }
    
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
    
    public LocalDate getNextExecutionDate() {
        return nextExecutionDate;
    }
    
    public void setNextExecutionDate(LocalDate nextExecutionDate) {
        this.nextExecutionDate = nextExecutionDate;
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    @Override
    public String toString() {
        return "RecurringTransaction [recurringId=" + recurringId + ", userId=" + userId + ", templateTransactionId="
                + templateTransactionId + ", frequency=" + frequency + ", nextExecutionDate=" + nextExecutionDate
                + ", isActive=" + isActive + "]";
    }
}