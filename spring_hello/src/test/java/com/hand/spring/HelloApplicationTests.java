package com.hand.spring;

import com.hand.spring.entity.*;
import com.sun.javaws.IconUtil;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.reverseOrder;

@SpringBootTest
class HelloApplicationTests {

    @Test
    public void foreachTest() {
        List<Hello> helloList = new ArrayList<>();
        Hello hello1 = new Hello();
        hello1.setValue("hello1");
        Hello hello2 = new Hello();
        hello2.setValue("hello2");
        helloList.add(hello1);
        helloList.add(hello2);
        System.out.println("before foreach: ");
        System.out.println(helloList);
        helloList.forEach(hello -> {
            hello.setValue("HELLO");
        });
        System.out.println("after foreach: ");
        System.out.println(helloList);
    }

    @Test
    public void booleanTest() {
        Boolean b1 = false;
        Boolean b2 = new Boolean(false);
        System.out.println(b1 == b2);
        System.out.println(b1.equals(b2));
        System.out.println(new Boolean(false).equals(null));
    }

    @Test
    public void calendarTest() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        Date date = new Date();
        System.out.println(date);
    }

    @Test
    public void dateUtilsTest() throws ParseException {
//        Date date = DateUtils.parseDate("2021-09-21");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2021-09-21 00:00:00");
        System.out.println(date.toString());
        Date date1 = DateUtils.addDays(date, 1);
        System.out.println(date1.toString());
        String date1Str = new SimpleDateFormat("yyyy-MM-dd").format(date1);
        System.out.println(date1Str);
    }

    @Test
    public void simpleDateFormatTest() throws ParseException {
//        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-09-21");
//        System.out.println(date);
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-09-21 00:00:00");
        System.out.println(date1);
//        Date date2 = new SimpleDateFormat().parse("2021-09-21 00:00:00");
//        System.out.println(date2);
//        Date date3 = new SimpleDateFormat().parse("2021-09-21");
//        System.out.println(date3);
    }

    @Test
    public void simpleDateFormatTest_2() throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-9-5");
        System.out.println(date1);
    }

    @Test
    public void lombokTest() {
        Person person = new Person();
        System.out.println(person.FIELD_NAME);
        System.out.println(person.FIELD_AGE);
        System.out.println(person.FIELD_FAMILY_REL);
    }

    @Test
    public void lombokTest_2() {
        Person person = new Person().builder().name("cjh").build();
        Person person1 = new Person().builder().name("cjh").age(18).familyRel("family").build();
        System.out.println(person.toString());
        System.out.println(person1.toString());
    }

    /*@Test
    public void lombokTest_3() {
        Person person = new Person("cjh", "rdj");
        System.out.println(person.toString());
    }*/

    @Test
    public void lombokTest_4() {
        Person person = new Person("rdj", 56, "cjh");
        System.out.println(person.toString());
        person =
                person.toBuilder().age(18).name("cjh").build();
        System.out.println(person.toString());
    }

    @Test
    public void listAddAllNPETest() {
        try {
            List<String> list = new ArrayList();
            List<String> addList = null;
            list.addAll(addList);
            System.out.println(list);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void clltUtilsTest() {
        List<String> list = null;
        System.out.println(CollectionUtils.isEmpty(list));
        list = new ArrayList<>(5);
        System.out.println(CollectionUtils.isEmpty(list));
        list.add("abc");
        System.out.println(CollectionUtils.isEmpty(list));
    }

    @Test
    public void clltUtilsTest_2() {
        List<Person> list = null;
        System.out.println(list);
        System.out.println(CollectionUtils.isEmpty(list));
        list = new ArrayList<>(5);
        System.out.println(list.toString());
        System.out.println(CollectionUtils.isEmpty(list));
        list.add(new Person());
        System.out.println(list.toString());
        System.out.println(CollectionUtils.isEmpty(list));
        list.add(new Person("cjh", 18, "rdj"));
        System.out.println(list.toString());
        System.out.println(CollectionUtils.isEmpty(list));
    }

    @Test
    public void optionalTest() {
        Optional<Person> opt = null;
        System.out.println(opt);
//        System.out.println(opt.isPresent()); // NPE
//        System.out.println(opt.get()); // NPE
        System.out.println("---------------------");
        Optional<Person> optEmpty = Optional.empty();
        System.out.println(optEmpty.toString());
        System.out.println(optEmpty.isPresent());
//        System.out.println(optEmpty.get()); //java.util.NoSuchElementException: No value present
        System.out.println("---------------------");
        List<Person> list = Arrays.asList(new Person("cjh", 18, "rdj"));
        Optional<Person> optOne = list.stream().findFirst();
        System.out.println(optOne.toString());
        System.out.println(optOne.isPresent());
        System.out.println(optOne.get());
    }

    @Test
    public void fieldTest() {
        Class claz = Hello.class;
        Field[] fields = claz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("name: " + field.getName());
            System.out.println("type: " + field.getType());
        }
    }

    @Test
    public void stringTest() {
        String string1 = "abd";
        String string2 = string1;
        String string3 = new String(string1);
        String string4 = new String(string1);
        System.out.println("string1: " + string1.hashCode());
        System.out.println("string2: " + string2.hashCode());
        System.out.println("string3: " + string3.hashCode());
        System.out.println("string4: " + string4.hashCode());
        System.out.println("string1 == string2: " + (string1 == string2));
        System.out.println("string2 == string3: " + (string2 == string3));
        System.out.println("string3 == string4: " + (string2 == string4));
    }

    @Test
    public void stringTest_2() {
        String[] strArr = {"a", "b", "c"};
        String str = String.join(",", strArr);
        System.out.println(Arrays.asList(strArr));
        System.out.println(str);
        str = String.join("-", strArr);
        System.out.println(str);
    }

    @Test
    public void mapTest() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("abc", "1");
        System.out.println("map1: " + map1.toString());
        Map<String, String> map2 = map1;
        System.out.println("map1 hashCode: " + map1.hashCode());
        System.out.println("map2 hashCode: " + map2.hashCode());
        map2.put("def", "2");
        System.out.println("map1: " + map1.toString());
        System.out.println("map2: " + map2.toString());
        Map<String, String> map3 = new HashMap<>(map1);
        System.out.println("map3 hashCode: " + map3.hashCode());
        map3.put("pqr", "10");
        System.out.println("map1: " + map1.toString());
        System.out.println("map2: " + map2.toString());
        System.out.println("map3: " + map3.toString());
        Map<String, Person> mapPerson = new HashMap<>();
        Person per = Person.builder().name("cjh").build();
        mapPerson.put("person1", per);
        System.out.println("mapPerson: " + mapPerson.toString());
    }

    @Test
    public void mapTest_2() {
        Map<String, String> map = null;
        System.out.println(map.isEmpty());
        Map<String, String> map2 = new HashMap<>();
        System.out.println(map2.isEmpty());
    }
    
    @Test
    public void mapTest_3() {
        Map<String, String> map = new HashMap<>();
        map.put("line", "1");
        map.put("code", "test");
        for (Map.Entry item: map.entrySet()) {
            System.out.println("Entry: " + item);
            System.out.println("Key: " + item.getKey());
            System.out.println("Value: " + item.getValue());
        }
    }

    @Test
    public void splitTest() {
        String str = "abcd";
        int ind1 = str.indexOf(97);
        int ind2 = str.indexOf("ab");
        int ind3 = str.indexOf("e");
        System.out.println(ind1);
        System.out.println(ind2);
        System.out.println(ind3);
    }

    @Test
    public void splitTest_2() {
        String str = "qwe.rt";
        String[] strArr = str.split("\\.");
        System.out.println(Arrays.asList(strArr));
        System.out.println(strArr[1]);
        String split = str.split("\\.")[0];
        System.out.println(split);
    }

    @Test
    public void listTest() {
        List<String> list = new ArrayList<>(1);
        list.add("a");
        System.out.println(list.contains(null));
    }

    @Test
    public void listTest_2() {
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list2.add("abc");
        list.addAll(null); // 不能通过，NPE
        System.out.println(list);
        System.out.println(list2);
    }

    @Test
    public void listTest_3() {
        List<String> list = Arrays.asList(new String[]{"1", "2"});
        System.out.println(list);
        System.out.println(list.toString());
    }

    @Test
    public void listTest_4() {
        List<String> list = new ArrayList<>();
        list.add(null);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(0));
    }

    @Test
    public void listTest_5() {
        List<String> list = new ArrayList<>();
        list.add(null);
        System.out.println(list.contains(null));
    }

    @Test
    public void listTest_6() {
        List<String> list = new ArrayList<>();
        list.add("R");list.add("D");list.add("J");
//        String[] strs = (String[]) list.toArray();
        System.out.println("-------");
        for (Object str:list.toArray()) {
            System.out.println(str);
        }
        System.out.println("--------");
    }

    @Test
    public void listTest_7() {
        List<Person> list = new ArrayList<>();
        System.out.println(list.toString());
        listInner(list);
        System.out.println(list.toString());
    }
    
    @Test
    public void listTest_8() {
        List<String> list = new ArrayList<>();
        list.add("H");list.add("e");
        System.out.println(list);
        list.remove("H");
        System.out.println(list);
    }
    
    @Test
    public void listTest_9() {
        List<Person> list = new ArrayList<>();
        Person p1 = new Person("cjh", 18, "RDJ, Susan");
        Person p2 = new Person("RDJ", 20, "Susan, cjh");
        list.add(p1);list.add(p2);
        System.out.println("list before: " + list);
        List<Person> conList = new ArrayList<>();
//        int ind = 0;
//        for (Person p : list) {
//            if (ind == 0) {
//                conList.add(p);
//            }
//            ind++;
//        }
        conList.add(list.get(0));
        System.out.println("conList: " + conList);
        list.removeAll(conList);
        System.out.println("list after removeAll: " + list);
//        Person p2_copy = list.get(0);
        Person p2_copy = new Person("RDJ", 20, "Susan, cjh");
        list.remove(p2_copy);
        System.out.println("list after remove: " + list);
    }
    
    public void listInner(List<Person> list) {
        list.add(new Person());
    }
    
    @Test
    public void listTest_10() {
        List<Person> list = new ArrayList<>();
        Person p1 = new Person("cjh", 18, "RDJ, Susan");
        Person p2 = new Person("RDJ", 20, "Susan, cjh");
        list.add(p1);list.add(p2);
        System.out.println("list before: " + list);
        listRemoveInner(list);
        System.out.println("list removed in outer method: " + list);
    }
    
    @Test
    public void listTest_11() {
        List<String> list1 = new ArrayList<>();
        list1.add("hello");list1.add("I'm");list1.add("cjh");
        System.out.println("list1: " + list1);
        List<String> list2 = new ArrayList<>(list1);
        System.out.println("list2: " + list2);
        list2.add("!!!");
        System.out.println("list1 after add: " + list1);
        System.out.println("list2 after add: " +list2);
        list1.set(0, "HELLO");
        list2.set(2, "CJH");
        System.out.println("list1 after set: " + list1);
        System.out.println("list2 after set: " +list2);
        list1 = list2;
        System.out.println("list1 after point to list2: " + list1);
    }
    
    @Test
    public void listTest_12() {
        List<Person> list = new ArrayList<>();
        Person p1 = new Person("cjh", 18, "RDJ, Susan");
        Person p2 = new Person("RDJ", 20, "Susan, cjh");
        list.add(p1);list.add(p2);
        System.out.println("list before: " + list);
        List<Person> list2 = new ArrayList<>(list);
        System.out.println("list2(copy list): " + list2);
        Person p2_copy = list2.get(0);
        p2_copy.setAge(100);
//        list2.set(0, p2_copy); // 可有可无，因为p2_copy是list2[0]的地址，改变p2_copy的值是改变地址所在位置的数组中元素的值
        System.out.println("list after: " + list); // 浅拷贝，和list2中元素一致；对于list2的对象的修改，影响到list
        System.out.println("list2 after: " + list2);
    }
    
    @Test
    public void ListTest_13() {
        List<String> list = new ArrayList<>(10);
        System.out.println(list.size());
    }

    @Test
    void listTest_14() {
        Animal ani = new Animal();
        System.out.println(ani.getCats());
        ani.getCats().add(new Cat());
    }

    @Test
    void listTest_15() {
        List<Person> list = new ArrayList<>();
        Person p1 = new Person("cjh", 18, "RDJ");
        Person p2 = new Person("rdj", null, "susan");
        list.add(p1);
        list.add(p2);
        list.sort(Comparator.comparing(Person::getAge));
        System.out.println(list);
    }
    
    public void listRemoveInner(List<Person> list) {
        list.removeIf(e -> e.getName().equals("cjh"));
        System.out.println("list removed in inner method: " + list);
    }

    @Test
    public void castTest() {
        Object obj = (Integer) 1;
        System.out.println(String.valueOf(obj));
    }

    @Test
    public void listSortTest_1() {
        List<Person> list = null;
        System.out.println("BEFORE: " + list);
        list.sort(Comparator.comparing(Person::getAge));
        System.out.println("AFTER ASC: " + list);
        list.sort(Comparator.comparing(Person::getAge, Comparator.reverseOrder()));
        System.out.println("AFTER DESC: " + list);
    }
    
    @Test
    public void listSortTest_2() {
        List<Person> list = new ArrayList<>();
        Person p1 = new Person("cjh", 18, null);
        Person p2 = new Person("rdj", 40, null);
        Person p3 = new Person("susan", 30, null);
        list.add(p1);list.add(p2);list.add(p3);
        System.out.println("BEFORE: " + list);
        list.sort(Comparator.comparing(Person::getAge));
        System.out.println("AFTER ASC: " + list);
//        list.sort(Comparator.comparing(Person::getAge, Comparator.reverseOrder()));
        list.sort(Comparator.comparing(Person::getAge).reversed());
        System.out.println("AFTER DESC: " + list);
    }

    @Test
    public void listSortTest_3() {
        List<Person> list = new ArrayList<>();
        Person p1 = new Person("cjh", 18, null);
        Person p2 = new Person("rdj", 40, null);
        Person p3 = new Person("other", null, null);
        Person p4 = new Person("susan", 30, null);
        
        list.add(p1);list.add(p2);list.add(p3);list.add(p4);
        System.out.println("BEFORE: " + list);
        list.sort(Comparator.comparing(Person::getAge, Comparator.nullsFirst(naturalOrder())));
        System.out.println("AFTER nullsFirst: " + list);
        list.sort(Comparator.comparing(Person::getAge, Comparator.nullsLast(naturalOrder())));
        System.out.println("AFTER nullsLast: " + list);
        list.sort(Comparator.comparing(Person::getAge, Comparator.nullsFirst(reverseOrder())));
        System.out.println("AFTER nullsFirst reverse: " + list);
        list.sort(Comparator.comparing(Person::getAge, Comparator.nullsLast(reverseOrder())));
        System.out.println("AFTER nullsLast reverse: " + list);
    }

    @Test
    public void threeOprtTest() {
        System.out.println("1".equals(null)? "1" : "0");
    }

    @Test
    public void dateTest() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.AM_PM, 0);
        date = cal.getTime();
        System.out.println(cal.toString());
        System.out.println(date.toString());
    }

    @Test
    public void stringBuilderTest() {
        StringBuilder builder = new StringBuilder("abc");
        builder.append("123");
        builder.insert(0,"789");
        System.out.println(builder.toString());
    }

    @Test
    public void stringBuilderTest_2() {
        List<StringBuilder> list = new ArrayList<>();
        StringBuilder builder1 = new StringBuilder("abc");
        StringBuilder builder2 = new StringBuilder("123");
        StringBuilder builder3 = new StringBuilder("789");
        list.add(builder1);list.add(builder2);list.add(builder3);
        System.out.println(String.join(",", list));
        List<StringBuilder> list2 = new ArrayList<>();
        System.out.println("list2: " + String.join(",", list2));
    }

    @Test
    public void stringBuilderTest_3() {
        List<StringBuilder> list = new ArrayList<>();
        StringBuilder builder1 = new StringBuilder();
        list.add(builder1);
        System.out.println(builder1.toString());
        System.out.println(list.toString());
    }

    @Test
    public void valueOfStringTest() {
        Person person = new Person();
        System.out.println(String.valueOf(person));
        System.out.println(StringUtils.isBlank(String.valueOf(person)));
        System.out.println(ObjectUtils.isEmpty(person));
        System.out.println(ObjectUtils.isEmpty(null));
        System.out.println(Integer.valueOf(null));
    }

    @Test
    public void distinctTest() {
        List<String> list1 = Arrays.asList(new String[]{"123", "123", "456"});
        List<String> res1 = list1.stream().collect(Collectors.toList());
        List<String> res2 = list1.stream().distinct().collect(Collectors.toList());
        System.out.println(res1);
        System.out.println(res2);
    }

    @Test
    public void distinctTest_2() {
        Person per1 = new Person("rdj", 18, "cjh");
        Person per2 = new Person(null, 18, "susan");
        List<Person> pers = new ArrayList<>();
        pers.add(per1);pers.add(per2);
        List<String> res1 = pers.stream().map(Person::getName).collect(Collectors.toList());
        List<String> res2 = pers.stream().map(Person::getName).filter(Objects::nonNull).distinct().collect(Collectors.toList());
        List<String> res3 = pers.stream().map(Person::getName).distinct().collect(Collectors.toList());
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(per1);
        System.out.println(per2);
    }

    @Test
    public void distinctTest_3() {
        Person per1 = new Person("rdj", 18, "cjh");
        Person per2 = new Person(null, 18, "susan");
        Restaurant rest1 = new Restaurant();
        rest1.setName("my restaurant");
        rest1.setOwner(per1);
        List<Person> pers = new ArrayList<>();
        pers.add(per1);pers.add(per2);
        List<Restaurant> rests = new ArrayList<>();
        rests.add(rest1);
        List<String> res1 = rests.stream().map(Restaurant::getName).collect(Collectors.toList());
        List<String> res2 = pers.stream().map(Person::getName).distinct().collect(Collectors.toList());
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(per1);
        System.out.println(per2);
    }

    @Test
    public void containsTest() {
        List<String> list = new ArrayList<>();
        System.out.println(list.contains(null));
    }

    @Test
    public void containsTest_2() {
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        System.out.println(list.contains(null));
        System.out.println(list.size());
        System.out.println(list);
    }

    @Test
    public void containsTest_3() {
        String str = "hello";
        System.out.println(str.contains("llo"));
    }

    @Test
    public void numberTest() {
        BigDecimal num = BigDecimal.ZERO;
        num.setScale(10);
        BigDecimal num2 = new BigDecimal("0.0000000000");
        num2.setScale(10);
        System.out.println(num.toString());
        System.out.println(num2);
//        System.out.println(BigDecimal.ZERO.equals(num));
    }

    @Test
    public void numberTest_2() {
        BigDecimal num = BigDecimal.ZERO;
        num.divide(new BigDecimal(10));
        System.out.println(num);
    }

    @Test
    public void numberTest_3() {
        int temp = 1;
        Integer tmpInt = 1;
        System.out.println(tmpInt.equals(null));
    }
    
    @Test
    public void exceptionTest() throws Exception {
        if (1 == 1) {
            throw new Exception("1 == 1");
        }
    }

    @Test
    public void exceptionTest_2(){
        try {
            if (1 == 1) {
                throw new Exception("1 == 1");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void exceptionTest_3() {
        try {
            throwExceptionOuter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void throwExceptionOuter() {
        throwExceptionInner();
    }

    private void throwExceptionInner() {
        throw new RuntimeException("Exception in inner method");
    }

    @Test
    public void parseTest() {
        String[] strs = new String[]{"'1'", "'2'"};
        List<Long> longList = Arrays.stream(strs.toString().split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
        System.out.println(longList);
    }
    
    @Test
    public void cloneTest() throws CloneNotSupportedException {
        Hello hello = new Hello("nihao!");
        Speaking speaking = new Speaking("i am cjh", null);

        System.out.println(hello);
        System.out.println(speaking);
        System.out.println("-----------------------");
        
        Speaking sp2 = speaking.clone();
        sp2.setHello(hello);
        System.out.println("speaking1: " + speaking);
        System.out.println("speaking2: " + sp2);
    }

    @Test
    public void iteratorTest() {
        List<String> list = new ArrayList<>();
        list.add("hello");list.add("food");list.add("sun");list.add("animals");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.contains("o")) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }
    
    @Test
    public void containTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(null);
        list.add(2);
        System.out.println(list.contains(2));
        System.out.println(list.contains(3));
        System.out.println(list.contains(null));
    }
    
    @Test
    public void callTest() {
//        int a = 0;
        Integer a = 0;
        System.out.println("Before transfer: a = " + a);
        transfer(a);
        System.out.println("After transfer: a = " + a);
    }
    
    public int transfer(int a) {
        a = 1;
        System.out.println("In transfer: a = " + a);
        return a;
    }

    public int transfer(Integer a) {
        a = 1;
        System.out.println("In transfer: a = " + a);
        return a;
    }
    
    @Test
    public void OrTest() {
        int a = -2;
        System.out.println(a);
        System.out.println(a >> 1);
        a |= a >> 1;
        System.out.println(a);
    }
    
    @Test
    public void reflectTest() {
        Father father = new Father();
        System.out.println(father.getClass());
        reflectInvoke(father);
    }
    
    public void reflectInvoke(Person person) {
        System.out.println(person.getClass());
    }
    
    @Test
    public void returnTest() {
        System.out.println("returnTest start");
        return_();
        System.out.println("returnTest end");
    }
    
    public void return_() {
        int i = 1;
        boolean b = false;
        do {
            if (i > 5) {
                b = true;
                break;
            }
            i++;
        } while (i <= 10 && !b);

        System.out.println(i);
        System.out.println(b);
    }
    
    @Test
    public void ifTest() {
        int a = 0, b = 1;
        if ((b = a) < 0) {
            System.out.println("in if...");
            System.out.println("a: " + a);
            System.out.println("b: " + b);
        } else {
            System.out.println("in else...");
            System.out.println("a: " + a);
            System.out.println("b: " + b);
        }
    }
    
    @Test
    public void bigDecimalTest() {
        System.out.println(BigDecimal.ONE.add(new BigDecimal("3")));
        System.out.println(new BigDecimal("1").add(new BigDecimal("3")));
    }
    
    @Test
    public void arrayTest() {
        String[] strArr = new String[5];
        strArr[0] = "hello";
        strArr[1] = "hi";
        System.out.println(strArr);
        System.out.println(strArr.length);
    }
    
    @Test
    public void booleanTest_2() {
        Boolean skipFlag = false;
        Hello hello = new Hello();
//        skipFlag = skipFlag != null && skipFlag;
        skipFlag = skipFlag != null && skipFlag && hello != null;
//        System.out.println(!skipFlag && hello != null);
        System.out.println(!skipFlag);
    }
    
    @Test
    public void nullTest() {
        System.out.println(null == null);
        System.out.println("".equals(null));
        List<String> list = null;
        for (String str : list) {
            System.out.println("1");
        }
    }
    
    @Test
    public void duplicateTest() throws CloneNotSupportedException {
        Person p1 = new Person("cjh", 18, "daddy");
        Person p2 = (Person) p1.clone();
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("----------------------------");
        p1.setAge(100);
        p2.setFamilyRel("daddy and mummy");
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
    }
    
    @Test
    void longTest() {
        long l = 1234;
//        Long ll = 1234; // 报错，包装类型必须要加后缀
//        float f = 12.12; // 报错
    }
    
    @Test
    public void tryTest() {
        int a = tryInvoke();
        System.out.println("=======In tryTest()=========");
        System.out.println(a);
    }
    
    public int tryInvoke() {
        int a = 0;
        System.out.println("=======In tryInvoke()=========");
        System.out.println(a);
        try {
            a = 2;
            System.out.println("=======In tryInvoke() try=========");
            System.out.println(a);
            a = 0 / 0; // ArithmeticException
            return a;
        } catch (ArithmeticException e) {
            a = 3;
            System.out.println("=======In tryInvoke() catch=========");
            System.out.println(a);
            return a;
        } finally {
            a = 4;
            System.out.println("=======In tryInvoke() finally=========");
            System.out.println(a);
//            return a;
        }
    }
    
    @Test
    public void switchTest() {
        String str = null;
        switch (str) {
            case "":
                System.out.println("this is empty");
                break;
            case "aaa":
                System.out.println("this is aaa");
                break;
        }
    }
    
    @Test
    public void bigDecimalTest_2() {
        BigDecimal bigDecimal = new BigDecimal("9.3314");
        System.out.println(bigDecimal);
    }
    
    @Test
    void bubbleSort() {
        int[] arr = new int[]{1, 5, 29, 39, 13, 46, 68, 94, 55, 30};
        System.out.println("--------------BEFORE SORT----------------");
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("--------------AFTER SORT----------------");
        System.out.println(Arrays.toString(arr));
    }
    
    @Test
    void streamTest() {
        List<Person> list = new ArrayList<>();
        Person p = new Person();
        list.add(p);
        List<String> collect = list.stream().map(Person::getName).distinct().collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    void streamTest_2() {
        List<Person> list = new ArrayList<>();
        List<String> collect = list.stream().map(Person::getName).distinct().collect(Collectors.toList());
        System.out.println(collect);
    }
    
    
}
