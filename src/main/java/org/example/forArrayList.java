package org.example;
import java.util.ArrayList;

/**
 * Класс реализующий функционал описанный в классе TimeMeasure для коллекции ArrayList
 * @author romanchervakov
 */
public class forArrayList extends TimeMeasure {
             ArrayList<Integer> cont;
             forArrayList(int times) {
                          super(times);
                          cont = new ArrayList<>();
             }
             @Override
             public long addTest() {
                                 watch.reset();
                                 watch.start();
                                 for (int i = 0; i < times; i++)
                                      cont.add(dice.nextInt());
                                 watch.stop();
                                 return watch.getNanoTime();
             }
             @Override
             public long removeTest() {
                                    if (cont.isEmpty()) addTest();
                                    watch.reset();
                                    watch.start();
                                    for (int i = 0; i < times; i++)
                                         cont.remove(dice.nextInt(cont.size()));
                                    watch.stop();
                                    return watch.getNanoTime();
             }
             @Override
             public long getTest() {
                                 if (cont.isEmpty()) addTest();
                                 watch.reset();
                                 watch.start();
                                 int num;
                                 for (int i = 0; i < times; i++)
                                      num = cont.get(dice.nextInt(times));
                                 watch.stop();
                                 return watch.getNanoTime();
             }
             @Override
             public long setTest() {
                                 if (cont.isEmpty()) addTest();
                                 watch.reset();
                                 watch.start();
                                 for (int i = 0; i < times; i++)
                                      cont.set(dice.nextInt(times), dice.nextInt());
                                 watch.stop();
                                 return watch.getNanoTime();
             }
             @Override
             public long toArrayTest() {
                                     if (cont.isEmpty()) addTest();
                                     watch.reset();
                                     watch.start();
                                     Object[] num = cont.toArray();
                                     watch.stop();
                                     return watch.getNanoTime();
             }
}

