package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {
   private final int[] data;
   private int point = 0;

   public EvenIterator(final int[] data) {
       this.data = data;
   }

   @Override
    public boolean hasNext() {
      boolean result = false;
      for (int index = point; index < data.length; index++) {
         if (data[index] % 2 == 0) {
             result = true;
            point = index;
            break;
         }
      }
      return result;
   }

   @Override
   public Integer next() {
      if (!hasNext()) {
         throw new NoSuchElementException();
      }
      return data[point++];
   }
}
