package domain.model;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

public class SubscriptionRequest {
    private int memberId;
    private int subscriptionType;
    private int subscriptionPeriodicity;
    private String status;
    private int subscriptionRequestId;
    private SubscriptionFees fees;
    private Date withdrawalDate;
    private PaymentMethod paymentMethod;

    private SubscriptionRequest(
        int memberId,
        int subscriptionType,
        int subscriptionPeriodicity,
        String status,
        int subscriptionRequestId,
        SubscriptionFees fees,
        @Nullable Date withdrawalDate,
        PaymentMethod paymentMethod
    ) {
        this.memberId = memberId;
        this.subscriptionType = subscriptionType;
        this.subscriptionPeriodicity = subscriptionPeriodicity;
        this.status = status;
        this.subscriptionRequestId = subscriptionRequestId;
        this.fees = fees;
        this.withdrawalDate = withdrawalDate;
        this.paymentMethod = paymentMethod;
    }

    public SubscriptionRequest monthly(
        int memberId,
        int subscriptionType,
        int subscriptionPeriodicity,
        String status,
        int subscriptionRequestId,
        SubscriptionFees fees,
        Date withdrawalDate,
        PaymentMethod paymentMethod
    ) {
        return new SubscriptionRequest(
            memberId,
            subscriptionType,
            subscriptionPeriodicity,
            status,
            subscriptionRequestId,
            fees,
            withdrawalDate,
            paymentMethod
        );
    }

    public SubscriptionRequest yearly(
        int memberId,
        int subscriptionType,
        int subscriptionPeriodicity,
        String status,
        int subscriptionRequestId,
        SubscriptionFees fees,
        PaymentMethod paymentMethod
    ) {
        return new SubscriptionRequest(
            memberId,
            subscriptionType,
            subscriptionPeriodicity,
            status,
            subscriptionRequestId,
            fees,
            null,
            paymentMethod
        );
    }



}
