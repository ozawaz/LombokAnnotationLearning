package achieve;

import lombok.Data;
import lombok.experimental.Accessors;

import java.lang.reflect.Field;

/**
 * @author ozawa
 * @version 1.0
 * @date 2022
 * @description achieve
 * @since JDK1.8
 */
public class AccessorsStudy {

    @Data
    @Accessors(fluent = true)
    public static class Student1{
        /**
         * 姓名
         */
        private String name;
        /**
         * 年龄
         */
        private Integer age;
    }

    @Data
    @Accessors(chain = true)
    public static class Student2{
        /**
         * 姓名
         */
        private String name;
        /**
         * 年龄
         */
        private Integer age;
    }

    @Data
    @Accessors(prefix = {"young, old"})
    public static class Student3{
        /**
         * 姓名
         */
        private String oldName;
        /**
         * 年龄
         */
        private Integer youngAge;
        /**
         * 地址
         */
        private String address;
    }

    public static Student1 testFluent() {
        Student1 student = new Student1();
        return student.name("这是fluent").age(18);
    }

    public static Student2 testChain() {
        Student2 student = new Student2();
        return student.setName("这是chain").setAge(19);
    }

    public static void testPrefix1() {
        Student3 student3 = new Student3();
        Field[] fields = student3.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field + " ");
        }
    }

    public static void testPrefix2() {
        Student3 student3 = new Student3();
//        student3.setName("这是prefix");
//        student3.setAge(20);
//        System.out.println(student3.getName() + " " + student3.getAge());
    }

    public static void main(String[] args) {
        Student1 student1 = testFluent();
        System.out.println(student1.name() + " " + student1.age());
        Student2 student2 = testChain();
        System.out.println(student2.getName() + " " + student2.getAge());
        testPrefix1();
        testPrefix2();
    }
}
