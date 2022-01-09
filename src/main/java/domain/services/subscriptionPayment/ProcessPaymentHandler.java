package domain.services.subscriptionPayment;

import domain.exception.InvalidArgumentException;
import domain.exception.MemberNotFoundException;
import domain.model.SubscriptionFees;
import domain.model.Member;
import domain.model.MemberStatus;
import infrastructure.exception.PaymentProcessingException;
import infrastructure.exception.UnknownPricingPlanException;
import infrastructure.repository.MemberRepository;
import utils.LoggerInterface;

public class ProcessPaymentHandler {

    private final PricingPlanService pricingPlanService;
    private final MemberRepository memberRepository;
    private final LoggerInterface logger;

    public ProcessPaymentHandler(
            PricingPlanService pricingPlanService,
            MemberRepository memberRepository,
            LoggerInterface logger
    ) {
        this.pricingPlanService = pricingPlanService;
        this.memberRepository   = memberRepository;
        this.logger             = logger;
    }

    public void handle(ProcessPaymentAction action) throws UnknownPricingPlanException, MemberNotFoundException, PaymentProcessingException, InvalidArgumentException {
        SubscriptionFees registrationFee = this.pricingPlanService.getMonthlyFeeForPlan(action.pricingPlan);

        Member member = this.memberRepository.findById(action.memberId);

        if(!makePayment(registrationFee)){
            this.logger.warning(
                String.format(
                    "%s - Erreur lors de l'opération de paiement du client : %d",
                    this.getClass().getSimpleName(),
                    member.getId()
                )
            );

            throw new PaymentProcessingException();
        }

        member.changeStatus(MemberStatus.APPROVED);
        memberRepository.update(member);
    }

    /**
     * Retourne true si le paiement a été effectué avec succès
     */
    private boolean makePayment(SubscriptionFees subscriptionFeesToPay){

        System.out.println("Processing payment ...");

        return true;
    }


}
