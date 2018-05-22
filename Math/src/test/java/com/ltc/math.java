package com.ltc;

import org.junit.Test;

public class math {
    /**
     * 暴力破解法
     *
     * 鸡兔同笼：
     *    有鸡兔共50头，共有脚120只！
     *
     *    问：鸡和兔各几只？
     *
     * 韩信点兵：
     *     韩信只知道部队有1000多人，但是具体数字不详
     *              5人一组，剩1人
     *              7人一组，剩2人
     *              8人一组，剩3人
     *
     *
     */

    @Test
    public void test01(){
        int head = 50;
        int foot = 120;

        for (int i=0;i<=50;i++){
               for(int y=0;y<=50;y++){
                   if((y==head-i)&&(2*i+4*y==foot)){
                       System.out.println("鸡的数量："+i);
                       System.out.println("兔的数量："+y);
                   }
               }

            }

        }

      @Test
     public void test02(){

        for(int i=1000;i<2000;i++){
            if(i%5==1&&i%7==2&&i%8==3){
                System.out.println("剩余的人数为："+i);
            }
        }

      }
    /**
     *
     */

    /**
     * 需要找零8元
     *    有零钱： 5元 2元  1元 5角
     *
     *    求出所有的找零方案
     *
     *    不要用0.1，涉及到0.1是浮点数，会造成精度丢失
     *
     */
    @Test
    public void test03(){
    int count = 0;
    for(int i=0;i<=80/5;i++){  //i====》0.5元
        for(int a=0;a<=80/10;a++){  //a===>1元
            for(int b=0;b<=80/20;b++){ //b===2元
                if((80-5*i-a*10-b*20)<0) break;
             int c =(80-5*i-a*10-b*20)/50; //c==>5 元
                    if((5*i+a*10+b*20+c*50)==80){
                        System.out.println("5角："+i+"===1元："+a+"====2元："+b+"===5元："+c);
                        count=count+1;
                    }

            }
        }
    }
    System.out.println("共有"+count+"种方法");
}

    /**
     * 数字自身平方的尾数于自身 （100w以内的）
     */

    @Test
    public void test04(){
        long begin = System.currentTimeMillis();
       for(int i = 0;i<=1000000;i++){
           int a = i*i;
           if(a%10==i||a%100==i||a%1000==i||a%10000==i||a%100000==i||a%1000000==i){
               System.out.println("平方尾数等于自身的数："+i+"平方数为："+i*i);
           }
       }
        long end =  System.currentTimeMillis();
        System.out.println("总耗时："+(end-begin));

        //优化后
        long begin1 = System.currentTimeMillis();
        for(int i = 0;i<=1000000;i++){
            int a = i*i;
            int b = i%10;
            if(b!=0&&b!=1&&b!=5&&b!=6){continue;}
            if(a%10==i||a%100==i||a%1000==i||a%10000==i||a%100000==i||a%1000000==i){
                System.out.println("平方尾数等于自身的数："+i+"平方数为："+i*i);
            }
        }
        long end1 =  System.currentTimeMillis();
        System.out.println("总耗时："+(end1-begin1));
    }










    }



























