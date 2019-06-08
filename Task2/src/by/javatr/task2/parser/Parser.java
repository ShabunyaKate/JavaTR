package by.javatr.task2.parser;

import by.javatr.task2.entity.Composite;

public abstract class Parser {
    Parser nextParser;
   public void setNextParser(Parser nextParser){
       this.nextParser=nextParser;
   }
   public Composite parseText(String strText){
       Composite text= parse(strText);
       return text;
   }
   public abstract Composite parse(String s);
}
