package domain.services.registration;

import domain.exception.MemberNotFoundException;
import domain.model.Member;
import domain.model.MemberStatus;
import infrastructure.exception.PaymentProcessingException;
import infrastructure.exception.UnknownPricingPlanException;
import infrastructure.repository.MemberRepository;
import infrastructure.repository.PricingPlanRepository;

public class ProcessPaymentHandler {

    private final PricingPlanRepository pricingPlanRepository;
    private final MemberRepository memberRepository;

    public ProcessPaymentHandler(
            PricingPlanRepository pricingPlanRepository,
            MemberRepository memberRepository
    ) {
        this.pricingPlanRepository  = pricingPlanRepository;
        this.memberRepository       = memberRepository;
    }

    public void handle(ProcessPaymentAction action) throws UnknownPricingPlanException, MemberNotFoundException, PaymentProcessingException {
        double registrationFee = this.pricingPlanRepository.getPricingFeeForPlan(action.pricingPlan);

        Member member = this.memberRepository.findById(action.memberId);

        if(!makePayment(registrationFee)){
            throw new PaymentProcessingException();
        }

        member.changeStatus(new MemberStatus(MemberStatus.APPROVED));
//        memberRepository.save();
    }

    /**
     * Retourne true si le paiement a été effectué avec succès
     */
    private boolean makePayment(double amountToPay){

        System.out.println("Processing payment ...");
        //Connection au service de paiement et fournir les informations de paiement : montant ...
        //récupérer le resultat de cette requête et retourner le booleen

        return true;
    }


}
