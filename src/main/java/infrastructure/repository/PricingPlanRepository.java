package infrastructure.repository;

import domain.model.Member;
import infrastructure.exception.UnknownPricingPlanException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PricingPlanRepository {
    public final int FREE_AND_HOBBY = 0;
    public final int PRODUCTION = 1;
    public final int ADVANCED = 2;

    private final Map<Integer, Double> data = new ConcurrentHashMap<>(){
        {
            this.put(FREE_AND_HOBBY, 0.00);
            this.put(PRODUCTION, 25.00);
            this.put(ADVANCED, 250.00);
        }
    };

    public Double getPricingFeeForPlan(int plan) throws UnknownPricingPlanException {
        if(!data.containsKey(plan)){
            throw new UnknownPricingPlanException();
        }
        return data.get(plan);
    }
}
