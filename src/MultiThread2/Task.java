package MultiThread2;

import java.util.concurrent.*;

// Класс возвращает результат задачи для других потоков, если он уже подсчитан одним из потоков
// Если в методе get возникает исключение, исключение будет вызвано и в других потоках, которые
// вызывают метод get
public class Task<T>{
    private Callable<T> callable;
 private volatile T result;
  private volatile boolean isResult = false;
boolean isException = false;

public Task(Callable<T> callable) {
     this.callable = callable;
    }

public T get() {
    if (isResult == true) {
        System.out.println("Результат возвращен-тест1 " + Thread.currentThread().getName());
     return result;
 }
    synchronized (this) {
      Thread.yield();
        if (isResult == true) {
            System.out.println("Результат возвращен-тест2 " + Thread.currentThread().getName());
            return result;
        }
     if (isException == true) {
         throw new GetEntryException("Ислючение во всех потоках");
        }
        T val;
        try {
            val = callable.call();
          isResult = true;
          result = val;
            System.out.println("Результат подсчитан, поток - "+ Thread.currentThread().getName());
            return val;
        } catch (Exception e) {
            System.out.println("Исключение в методе get");
            isException = true;
            e.printStackTrace();
            throw new GetEntryException("Исключение в методе get");
        }

    }

}


}
