package designpatterns.strategy;

/**
 * Created by machenggong on 2019/12/13.
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 *作者：alaric
 *时间：2013-8-5上午11:31:12
 *描述：策略工厂 使用单例模式
 */
public class StrategyFactory {

    private static StrategyFactory factory = new StrategyFactory();
    private StrategyFactory(){
    }
    private static Map<Integer ,Strategy> strategyMap = new HashMap<>();
    static{
        strategyMap.put(RechargeTypeEnum.E_BANK.value(), new EBankStrategy());
        strategyMap.put(RechargeTypeEnum.BUSI_ACCOUNTS.value(), new BusiAcctStrategy());
        strategyMap.put(RechargeTypeEnum.MOBILE.value(), new MobileStrategy());
        strategyMap.put(RechargeTypeEnum.CARD_RECHARGE.value(), new CardStrategy());
    }
    public Strategy creator(Integer type){
        return strategyMap.get(type);
    }
    public static StrategyFactory getInstance(){
        return factory;
    }
}
