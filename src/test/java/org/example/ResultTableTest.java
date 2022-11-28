package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ResultTableTest extends ResultTable {
      ResultTableTest() { super(5000); }
      // Проверка правильности вставки значений в таблицу
      @Test
      void insertTest() {
                      StringBuilder it = new StringBuilder("|      remove     |                     |                  |");
                      long n = 6565984;
                      insert(n, 41, 18, it);
                      assertEquals("|      remove     |                     |     6565984      |", it.toString());
      }
      // Проверка правильности заполнения шаблона таблицы
      @Test
      void templateTest() {
                        String fullTemplate = "\n|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|" +
                                              "\n| Название метода | Колличество вызовов | Время выполнения |" +
                                              "\n|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|" +
                                              "\n|       add       |                     |                  |" +
                                              "\n|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|                     |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|" +
                                              "\n|      remove     |                     |                  |" +
                                              "\n|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|                     |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|" +
                                              "\n|       get       |        5000         |                  |" +
                                              "\n|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|                     |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|" +
                                              "\n|       set       |                     |                  |" +
                                              "\n|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|                     |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|" +
                                              "\n|      toArray    |                     |                  |" +
                                              "\n‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾";
                        assertEquals(fullTemplate, template().toString());
      }
}