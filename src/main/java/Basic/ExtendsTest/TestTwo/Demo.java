package Basic.ExtendsTest.TestTwo;

class Person{
    String name = "no name";
    public Person(String name){
        this.name = name;
    }
}
class Employee extends Person{
    String empID = "0000";
    public Employee(String id){
        //此处必须显示调用super()，否则会报错。因为父类没有无参的构造函数
        super(id);
        empID = id;
    }
}
public class Demo {
    public static void main(String[] args) {
        Employee e = new Employee("123");
        System.out.println(e.empID);
    }
}
