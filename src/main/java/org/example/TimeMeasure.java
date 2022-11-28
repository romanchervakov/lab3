package org.example;
import org.apache.commons.lang3.time.StopWatch;
import java.util.Random;

/**
 * Класс для измерения времени выполнения методов коллекций
 * @author romanchervakov
 */
public abstract class TimeMeasure {
                      protected Random dice;
                      protected StopWatch watch;
                      protected int times;
                      /**
                       * Конструктор класса инициализрует секундомер, рандомайзер и число запусков методов
                       * @param times число запусков методов
                       */
                      TimeMeasure(int times) {
                                  dice = new Random();
                                  watch = new StopWatch();
                                  this.times = times;
                      }
                      /**
                       * Засекаяет время выполнения метода add
                       * @return время выплнения
                       */
                      abstract long addTest();
                      /**
                       * Засекаяет время выполнения метода remove
                       * @return время выплнения
                       */
                      abstract long removeTest();
                      /**
                       * Засекаяет время выполнения метода get
                       * @return время выплнения
                       */
                      abstract long getTest();
                      /**
                       * Засекаяет время выполнения метода set
                       * @return время выплнения
                       */
                      abstract long setTest();
                      /**
                       * Засекаяет время выполнения метода toArray
                       * @return время выплнения
                       */
                      abstract long toArrayTest();
}
