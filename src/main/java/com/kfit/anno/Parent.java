package com.kfit.anno;

/**
 * Created by davi on 2017/8/20.
 */
@MyAnno
public class Parent {

   @MyAnno
   public void ParentMe1(){
      System.out.println(11);
      ParentMe2();
   }

   @MyAnno
   public void ParentMe2(){
      System.out.println(22);
   }
}
