package com.example.numbersgame;

import java.util.LinkedList;

import android.graphics.Paint;

/**
 * Created by Александр on 19.03.2016.
 * Базовый класс слоя.
 *
 * На слое мы располагаем различных экторов и работаем с ними.
 * Слои позволят нам разделять экторов на группы к примеру:
 * cлой с задним фоном, сслой с врагами, слой с передним фоном.
 * Таким образом нам будет удобнее работать с большими количествами экторов.
 */
public class c__basic_layer
{
    public LinkedList<c__basic_actor> o__ll_actors; // Список экторов на слое

    private int     i__level;                    // Позиция слоя
    public  Paint   o__paint;                    // Кисть, которой мы рисуем на слое

    //
    // Индикатор того, что данные в слое обрабатываются.
    // Создана из-за того, что LinkedList не поддерживает работу нескольких операций
    // одновременно.
    //
    private boolean b__processing;


    /**
     * Конструктор
     *
     * @param  @int  i__set_level  Позиция слоя
     */
    public c__basic_layer(int i__set_level)
    {
        b__processing = true;         // Ставим флаг обработки данных
        i__level      = i__set_level; // Устанавливаем уровень слоя
        o__paint      = new Paint();  // Устанавливам кисть
        b__processing = false;        // Снимаем флаг обработки данных
    }


    //============================================================================//
    //  Функции для работы с экторами на слое                                     //
    //============================================================================//

    /**
     * Функция добавления эктора на слой
     *
     * @param  @c__basic_actor  o__ba_actor  Эктор, которого добавляем
     */
    public void add_actor(c__basic_actor o__ba_actor)
    {
        b__processing = true;          // Ставим флаг обработки данных
        o__ll_actors.add(o__ba_actor); // Добавляем нового эктора в список
        b__processing = false;         // Снимаем флаг обработки данных
    }


    /**
     * Функция возвращающая количество экторов на слое
     *
     * @return  int
     */
    public int get_actor_count()
    {
        return o__ll_actors.size();
    }


    /**
     * Функция возвращающая эктора по позиции в списке
     *
     * @param  @int  i__actor_index  Номер эктора в списке
     *
     * @return  c__basic_actor
     */
    public c__basic_actor get_actor_by_index(int i__actor_index)
    {
        return o__ll_actors.get(i__actor_index);
    }


    /**
     * Функция удаления эктора со слоя
     *
     * @param  @int  i__actor_index  Номер эктора в списке
     */
    public void delete_actor_by_index(int i__actor_index)
    {
        b__processing = true;                 // Ставим флаг обработки данных
        o__ll_actors.remove(i__actor_index);  // Удаляем эктора
        b__processing = false;                // Снимаем флаг обработки данных
    }


    /**
     * Функция очищает список экторов
     */
    public void clear()
    {
        b__processing = true;  // Ставим флаг обработки данных
        o__ll_actors.clear();  // Очищаем список экторов
        b__processing = false; // Снимаем флаг обработки данных
    }


    /**
     * Функция обновления всех объектов на слое
     */
    public void update_layer()
    {
        b__processing = true;  // Ставим флаг обработки данных

        //Вызываем метод обновления для каждого эктора на слое
        for (c__basic_actor o__ba_actor : o__ll_actors)
        {
            o__ba_actor.update();
        }

        b__processing = false; // Снимаем флаг обработки данных
    }


    /**
     * Фукнция возвращает первого эктора на слое в которого входит точка
     *
     * @param  @float  f__x  Координата точки по оси X
     * @param  @float  f__y  Координата точки по оси Y
     *
     * @return  c__basic_actor
     */
    public c__basic_actor get_selected_actor(float f__x, float f__y)
    {
        c__basic_actor o__ba_tmp = null;  // Создаем временного эктора для прохода по циклу

        //
        // Вызываем функцию проверки на вхождение точки для каждого эктора на слое.
        // После обнаружения активного эктора - выходим из цикла.
        //
        for (int i = 0; i < o__ll_actors.size(); i++ )
        {
            // Проверяем эктора на активность
            if ( o__ll_actors.get(i).is_selected(f__x, f__y) )
            {
                o__ba_tmp = o__ll_actors.get(i);
                break;
            }
        }

        return o__ba_tmp;
    }

    //============================================================================//


    /**
     * Функция получения флага Processing
     *
     * @return  boolean
     */
    public boolean get_processing()
    {
        return b__processing;
    }
}
