package designpatterns.strategy;

/**
 * Created by mache on 2019/12/13.
 */

/**
 * 作者：alaric
 * 时间：2013-8-5上午11:13:46
 * 描述：充值卡充值
 */
public class CardStrategy implements Strategy {

    @Override
    public Double calRecharge(Double charge, RechargeTypeEnum type) {
        return charge + charge * 0.01;
    }

}
