package hellojpa;

public class ValueMain {
    public static void main(String[] args) {

        Integer a = new Integer(10);
        Integer b = a;

        /**
         * int, double 같은 기본 타입(primitive type)은 절대 공유 X
         * 기본 타입은 항상 값을 복사함
         * Integer 같은 래퍼 클래스나 String 같은 특수한 클래스는 공유 가능한 객체이지만 변경 X
         */
    }
}
