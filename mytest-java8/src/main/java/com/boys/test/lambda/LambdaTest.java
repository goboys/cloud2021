package com.boys.test.lambda;


import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

public class LambdaTest {

    @Test
    public void Test(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello word!");
            }
        };

        runnable.run();

        Runnable r2 = ()->System.out.println("hello word - r2!");
        r2.run();

        /**
         * 如下：lambda表达式就是对 Consumer 接口中 accept 方法实现。
         */
        Consumer con = (x)->System.out.println(x);
        con.accept("hello consumer");

        Consumer con2 = x->System.out.println(x);
        con2.accept("hello consumer2");

        Consumer con3 = x->{
            System.out.println(x);
            System.out.println("完成了！");
        };
        con3.accept("hello consumer3");

        
        Comparator<Integer> com = (x,y) -> x.compareTo(y);
        System.out.println(com.compare(5,2));


    }

    public Integer test1(Integer num){
        return num;
    }

    /**
     * 获得年龄大于35的
     * @param list
     * @return
     */
    public List<Employee> getEmployeeList(List<Employee> list){
        List<Employee> tempList = new ArrayList<>();
        for(Employee employee:list){
            if(employee.getAge()>35){
                tempList.add(employee);
            }
        }

        return tempList;
    }

    @Test
    public void test3(){

        //获得大于35的
        //方式一:传统方式
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1L,"张三1111",28,8000));
        employeeList.add(new Employee(2L,"李四14441",38,10000));
        employeeList.add(new Employee(3L,"王五11",28,8000));
        employeeList.add(new Employee(4L,"赵六111",38,15000));
        employeeList.add(new Employee(5L,"田七1",36,9000));

        List<Employee> list = getEmployeeList(employeeList);
        for(Employee employee:list){
            System.out.println(employee);
        }

        System.out.println("-----------------------------------------策略模式");
        //方式二:策略模式
        List<Employee> list2 = filterEmployee(employeeList,new MyPredicateAge());
        for(Employee employee:list2){
            System.out.println(employee);
        }

        System.out.println("-----------------------------------------lambda表达式");
        //--改成lambda表达式
        List<Employee> list3 = filterEmployee(employeeList,t-> t.getAge()>35);
        for(Employee e:list3){
            System.out.println(e);
        }
        System.out.println("-----------------------选出年龄大于35 和 工资大于9000的员工");
        List<Employee> list4 = filterEmployee(employeeList,t->t.getAge()>35&t.getWage()>9000);
        for(Employee e:list4){
            System.out.println(e);
        }




//        System.out.println("------------------------------------------lambda");
//        //方式三:lambda表达式
//        List<Employee> list3 = filterEmployee(employeeList,(e)->e.getAge()>35);
//        list3.forEach(System.out::println);

         Collections.sort(employeeList,(o1,o2)->{
           if(o1.getAge()>o2.getAge()){
               return 1;
           }else if(o1.getAge()<o2.getAge()){
               return -1;
           }else if(o1.getName().length()>o2.getName().length()){
               return 1;
           }else if(o1.getName().length()<o2.getName().length()){
               return -1;
           }
           return 0;
        });

        System.out.println("------------------------------------->Collections排序");
        for(Employee e:employeeList){
            System.out.println(e);
        }




    }

    public List<Employee> filterEmployee(List<Employee> list,MyPredicate<Employee> mp){

        List<Employee> tempList = new ArrayList<>();
        for(Employee e:list){
            if(mp.test(e)){
                tempList.add(e);
            }
        }

        return tempList;

    }


    @Test
    public void test5(){
        //获得大于35的
        //方式一:传统方式
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1L,"张三1111",28,8000));
        employeeList.add(new Employee(2L,"李四14441",38,10000));
        employeeList.add(new Employee(3L,"王五11",28,8000));
        employeeList.add(new Employee(4L,"赵六111",38,15000));
        employeeList.add(new Employee(5L,"田七1",36,9000));

        //排序-按年龄比较
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Integer.compare(o1.getAge(),o2.getAge());
            }
        });

        Collections.sort(employeeList,(e1,e2)->{
            return -Integer.compare(e1.getAge(),e2.getAge());
        });

        for(Employee e:employeeList){
            System.out.println(e.toString());
        }

    }




}
