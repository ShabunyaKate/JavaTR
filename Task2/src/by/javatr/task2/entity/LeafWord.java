package by.javatr.task2.entity;

import java.util.Objects;

public class LeafWord implements Component {
     private String word;

     public LeafWord(String word) {
       this.word=word;
    }

     @Override
     public  int matchStr(String str){
         if(str.equals(word)){
             return 1;
         }
         else return 0;
     }
     @Override
     public int leafLength(){
         return word.length();
    }
     @Override
     public int getLength(){// проверка на null
         return word.length();
     }
     @Override
     public String toString(){
         return word+DELIMETER;
     }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeafWord leafWord = (LeafWord) o;
        return Objects.equals(word, leafWord.word);
    }
    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
}
