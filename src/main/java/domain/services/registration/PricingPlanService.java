package domain.services.registration;

import domain.exception.InvalidArgumentException;
import domain.model.SubscriptionFees;
import infrastructure.exception.UnknownPricingPlanException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PricingPlanService {

    public final int FREE = 0;
    public final int PREMIUM = 1;
    public final int VIP = 2;

    private final Map<Integer, Double> data = new ConcurrentHashMap<>(){
        {
            this.put(FREE, 0.00);
            this.put(PREMIUM, 25.00);
            this.put(VIP, 250.00);
        }
    };

    public SubscriptionFees getMonthlyFeeForPlan(int plan) throws UnknownPricingPlanException, InvalidArgumentException {
        if(!data.containsKey(plan)){
            throw new UnknownPricingPlanException();
        }

        return new SubscriptionFees(data.get(plan));
    }
}
