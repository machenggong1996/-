package bishi.niuke;

/**
 * @author machenggong
 * @date 2020/12/29
 * @description
 */
public class TestDemo1 {

    private final int count;

    public static void main(String[] args) {
        TestDemo1 testDemo1 = new TestDemo1(88);
        System.out.println(testDemo1.count);
        int a = 8;
        boolean b = (a!=3&&a!=4&&a!=5&&a!=6);
        System.out.println(b);
    }

    public TestDemo1(int a){
        count = a;
    }

}
