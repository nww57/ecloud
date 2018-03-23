package com.sunesoft.ecloud.admin;

import com.sunesoft.ecloud.admin.demon.DemoQuery;
import com.sunesoft.ecloud.admin.demon.Test1;
import com.sunesoft.ecloud.admin.demon.EUser;
import org.assertj.core.internal.cglib.beans.BeanMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author: Zhouzh
 * @Date: 2018/3/21
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class sysAdminApplicationBootstrapTest {


    @Autowired
    DemoQuery ttt;

    @Test
    public void m() {

        Long s = new Date().getTime();
        ttt.m();
        Long e = new Date().getTime();
        System.out.println(e - s);
        Long s2 = new Date().getTime();
        ttt.m2();
        Long e2 = new Date().getTime();
        System.out.println(e2 - s2);

        Long s3= new Date().getTime();
        ttt.page();
        Long e3 = new Date().getTime();
        System.out.println(e3 - s3);
    }

    @Test
    public void test() throws IllegalAccessException, InstantiationException {


        EUser eUser11 = new EUser();

        EBeanMap beanMap = new EBeanMap(eUser11);

//        Map<String, Object> map2 = new HashMap<>();
//
//        map2.put("userName", "abc");
//        map2.put("password", "abc");
//        map2.put("datea",new Date());
//        map2.put("test111", "AA");
//        map2.put("userName1", "abc");
//        map2.put("password1", "abc");
//        map2.put("datea1",new Date());
//        map2.put("test1112", "AA");
//        map2.put("userName2", "abc");
//        map2.put("password2", "abc");
//        map2.put("datea3",new Date());
//        map2.put("test1114", "AA");
//
//        EUser eUser2 = new EUser();
//
//        EBeanMap beanMap2 = EBeanMap.create(eUser2);
//
//        for (String o : map2.keySet()) {
//
//            if(beanMap2.getPropertyType(o)!=null&&beanMap2.getPropertyType(o).isEnum()){
//                beanMap2.put(o,Test1.AA);
//            }
//            else
//                beanMap2.put(o,map2.get(o));
//        }
        this.beanMap();
//          this.selfBeanMap();
        reflect();
        this.beanMap();
//        this.selfBeanMap();
        reflect();

    }


    private void reflect() throws IllegalAccessException, InstantiationException {

        List<Map<String, Object>> maps = getMaps();
        Long start = new Date().getTime();


        Field[] fields = EUser.class.getDeclaredFields();

        for (Map<String, Object> map : maps) {
            EUser EUser = EUser.class.newInstance();
            for (String o : map.keySet()) {
                for (int j = 0; j < fields.length; j++) {
                    Field f = fields[j];
                    if (f.getName().equals(o)) {
                        boolean flag = f.isAccessible();
                        f.setAccessible(true);
                        try {
                            f.set(EUser, map.get(o));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        f.setAccessible(flag);
                        break;
                    }
                }
            }
        }
        Long end = new Date().getTime();


        System.out.println(end - start
        );
    }

    private void selfBeanMap() {
        List<Map<String, Object>> maps = getMaps();

        Long start = new Date().getTime();
        for (Map<String, Object> map : maps) {
            EUser EUser = new EUser();

            EBeanMap beanMap = new EBeanMap(EUser);

            for (String o : map.keySet()) {

                if (beanMap.get(o) != null && beanMap.get(o).getClass().isEnum()) {
                    beanMap.put(o, Test1.AA);
                } else
                    beanMap.put(o, map.get(o));
            }
        }
        Long end = new Date().getTime();


        System.out.println(end - start
        );
    }


    private List<Map<String, Object>> getMaps() {
        List<Map<String, Object>> maps = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Map<String, Object> map = new HashMap<>();

            map.put("userName", "abc");
            map.put("password", "abc");
            map.put("datea", new Date());
            map.put("test111", "AA");
            map.put("userName1", "abc");
            map.put("password1", "abc");
            map.put("datea1", new Date());
            map.put("test1112", "AA");
            map.put("userName2", "abc");
            map.put("password2", "abc");
            map.put("datea3", new Date());
            map.put("test1114", "AA");

            map.put("userName2", "abc");
            map.put("password2", "abc");
            map.put("datea2", new Date());
            map.put("test1112", "AA");
            map.put("userName12", "abc");
            map.put("password12", "abc");
            map.put("datea12", new Date());
            map.put("test11122", "AA");
            map.put("userName22", "abc");
            map.put("password22", "abc");
            map.put("datea32", new Date());
            map.put("test11142", "AA");
            maps.add(map);
        }

        return maps;

    }

    private void beanMap() {
        List<Map<String, Object>> maps = getMaps();

        Long start = new Date().getTime();
        for (Map<String, Object> map : maps) {

            EUser EUser = new EUser();
            BeanMap beanMap = BeanMap.create(EUser);

            for (String o : map.keySet()) {

                if (beanMap.getPropertyType(o) != null && beanMap.getPropertyType(o).isEnum()) {
                    beanMap.put(o, Test1.AA);
                } else
                    beanMap.put(o, map.get(o));
            }
        }
        Long end = new Date().getTime();


        System.out.println(end - start
        );
    }

}