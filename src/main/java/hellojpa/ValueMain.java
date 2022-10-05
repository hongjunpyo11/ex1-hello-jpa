package hellojpa;

public class ValueMain {
    public static void main(String[] args) {

        Address address1 = new Address("city", "street", "10000");
        Address address2 = new Address("city", "street", "10000");

        System.out.println(address1 == address2);
        System.out.println(address1.equals(address2));

        /**
         * 값 타입의 비교
         * * 동일성(identity) 비교: 인스턴스의 참조 값을 비교, == 사용
         * * 동등성(equivalence) 비교: 인스턴스의 값을 비교, equals() 사용
         */

    }
}
