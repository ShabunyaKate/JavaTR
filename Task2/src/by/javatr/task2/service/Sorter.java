package by.javatr.task2.service;

import by.javatr.task2.entity.Composite;
import by.javatr.task2.entity.LeafWord;

public class Sorter {
    public void sortParagraph(Composite text) {//абзац по колво предложений
        Composite a,b;//paragraph1 paragrapgh2
        for(int i=0;i<text.getCompositeLength();i++) {
            a = text.getCompositeElement(i);
            b = text.getCompositeElement(i + 1);
            if (a.getCompositeLength() > b.getCompositeLength()) {
                swapComposite(a, b);
            }
        }
    }
    public void sortSentense(Composite text, String str){ // предлродения в абзаце по количеству вхождений слова
        Composite paragraph, sentense1,sentense2;
        for(int i=0;i<text.getCompositeLength();i++) {
            paragraph=text.getCompositeElement(i);
            for(int j=0;j<paragraph.getCompositeLength()-1;j++){
                sentense1=paragraph.getCompositeElement(i);
                sentense2=paragraph.getCompositeElement(i+1);
                if(countOfWordMatches(sentense1,str)>countOfWordMatches(sentense2,str)){
                    swapComposite(sentense1,sentense2);
                }
            }
        }
    }
    public void sortWord(Composite text){// сортировка слов в предложении по длине
        Composite paragraph, sentense,lexem;
        LeafWord a,b;
        for(int i=0;i<text.getCompositeLength();i++) {
          paragraph=text.getCompositeElement(i);
          for(int j=0;j<paragraph.getCompositeLength();j++){
              sentense=paragraph.getCompositeElement(j);
              for(int k=0; k<sentense.getCompositeLength();k++){
              lexem=sentense.getCompositeElement(k);
              for(int n=0;n<lexem.getCompositeLength();n++){
                  if(lexem.getElement(i) instanceof LeafWord&&lexem.getElement(i+1) instanceof LeafWord) {
                      a = (LeafWord) lexem.getElement(i);
                      b = (LeafWord) lexem.getElement(i + 1);
                      if (a.getLeafLength() > b.getLeafLength()) {
                          swapLeafWord(a, b);
                      }
                  }
              }
              }
          }
        }
    }
    public int countOfWordMatches(Composite sentense, String word){//количество совпадений
        Composite lexem;
        LeafWord wordLeaf;
        int countMatches=0;
        for(int i=0;i<sentense.getCompositeLength();i++){
             lexem=sentense.getCompositeElement(i);
             for(int j=0;j<lexem.getCompositeLength();j++){
                 wordLeaf=lexem.getLeafElement(j);
                 if(word.equals(wordLeaf.toString())){
                     countMatches++;
                 }
             }
        }
        return countMatches;
    }
    private void swapComposite(Composite a,Composite b) {//два свэпа в один для общего вида T
        Composite buf =a;
        a=b;
        b=buf;
    }
    private void swapLeafWord(LeafWord a,LeafWord b){
        LeafWord buf =a;
        a=b;
        b=buf;
    }
}
