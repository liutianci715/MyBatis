package com.ltc;

import org.junit.Test;

public class Math {
    @Test
    public  void math01(){


        for(int i=0;i<=50;i++){
            int y = 50-i;
            if(y==120/i) {
                System .out.println("鸡："+i);
                System.out.println("兔:"+y);            }
        }
    }

}
