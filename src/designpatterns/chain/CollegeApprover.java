package designpatterns.chain;

/**
 * @author machenggong
 * @date 2021/1/9
 * @description
 */
public class CollegeApprover extends Approver {

    public CollegeApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getPrice() <= 10000 && request.getPrice() > 5000) {
            System.out.println("请求编号=" + request.getId() + "被" + this.name + "处理");
        } else {
            approver.processRequest(request);
        }
    }
}
