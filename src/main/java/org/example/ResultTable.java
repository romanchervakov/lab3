package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс формирующий таблицы результатов измерений времени выполнения методов коллекций ArrayList и LinkedList'
 * @author romanchervakov
 */
public class ResultTable {
             protected final String ALTable;
             protected final String LLTable;
             protected final int times;
             /**
              * Геттер
              * @return обьект типа String с таблицей времени выполнения методов коллекции ArrayList
              */
             String getArrayListTable() { return "\nВремя выполнения методов коллекции ArrayList\n" + ALTable; }
             /**
              * Геттер
              * @return обьект типа String с таблицей времени выполнения методов коллекции LinkedList
              */
             String getLinkedListTable() { return "\nВремя выполнения методов коллекции LinkedList\n" + LLTable; }
             /**
              * Метод для вставки значений в таблицу
              * @param n значение
              * @param pos место вставки
              * @param case_len длина графы
              * @param table таблица вставки
              */
             protected void insert(long n, int pos, int case_len, StringBuilder table) {
                                   String num = Long.toString(n);
                                   int length = num.length(), mid = pos + (case_len-length)/2;
                                   table.replace(mid, mid + length, num);
             }
             /**
              * Метод формирующий шаблон таблицы
              * @return обьект типа StringBuilder с шаблоном таблицы
              */
             protected StringBuilder template() {
                                              String top1 = "\n|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|";
                                              String top2 = "\n|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|                     |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|";
                                              String right = "                     |                  |";
                                              StringBuilder template = new StringBuilder();
                                              template.append(top1).append("\n| Название метода | Колличество вызовов | Время выполнения |");
                                              template.append(top1).append("\n|       add       |").append(right);
                                              template.append(top2).append("\n|      remove     |").append(right);
                                              template.append(top2).append("\n|       get       |").append(right);
                                              template.append(top2).append("\n|       set       |").append(right);
                                              template.append(top2).append("\n|      toArray    |").append(right);
                                              template.append("\n‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
                                              insert(times, 447, 21, template);
                                              return template;
             }
             /**
              * Конструктор класса заполняет таблицы значениями измерений
              * @param times число запусков методов
              */
             ResultTable(int times) {
                         this.times = times;
                         forArrayList AL = new forArrayList(times);
                         forLinkedList LL = new forLinkedList(times);

                         StringBuilder ALTable = new StringBuilder(template());
                         insert(AL.addTest(), 225, 18, ALTable);
                         insert(AL.removeTest(), 347, 18, ALTable);
                         insert(AL.getTest(), 469, 18, ALTable);
                         insert(AL.setTest(), 591, 18, ALTable);
                         insert(AL.toArrayTest(), 713, 18, ALTable);
                         this.ALTable = ALTable.toString();

                         StringBuilder LLTable = new StringBuilder(template());
                         insert(LL.addTest(), 225, 18, LLTable);
                         insert(LL.removeTest(), 347, 18, LLTable);
                         insert(LL.getTest(), 469, 18, LLTable);
                         insert(LL.setTest(), 591, 18, LLTable);
                         insert(LL.toArrayTest(), 713, 18, LLTable);
                         this.LLTable = LLTable.toString();
             }
             /**
              * Метод для вывода таблиц в консоль
              */
             void output() { System.out.print(getArrayListTable() + getLinkedListTable()); }
             /**
              * Метод для вывода таблиц в файл
              * @param path путь к файлу
              */
             void output(String path) {
                         try {
                              BufferedWriter writer = new BufferedWriter(new FileWriter(path));
                              writer.write(getArrayListTable() + getLinkedListTable());
                              writer.close();
                         } catch (IOException e) {
                                  e.printStackTrace();
                         }
             }
}
