package com.example.numbersgame;

/**
 * Created by Александр on 19.03.2016.
 * Базовый класс сцены.
 *
 * Сцена - набор слоев.
 */
public class c__basic_scene
{
    private c__basic_layer[] a__layers;        // Массив слоев
    private int              i__current_layer; // Активный слой
    private int              i__layers_count;  // Количество слоев


    /**
     * Конструктор
     *
     * @param  @int  i__count  Количество слоев на сцене
     */
    public c__basic_scene(int i__count)
    {
        i__layers_count = i__count;                      // Устанавливаем количество слоев
        a__layers       = new c__basic_layer[i__count];  // Устанавливаем массив со слоями
    }


    //============================================================================//
    //  Функции для работы со слоями на сцене                                     //
    //============================================================================//

    /**
     * Функция установки текущего слоя
     *
     * @param  @int  i__current  Индекс текущего слоя
     */
    public void set_current_layer(int i__current)
    {
        i__current_layer = i__current;
    }


    /**
     * Функция, возвращающая текущий слой
     *
     * @return c__basic_layer
     */
    public c__basic_layer get_current_layer()
    {
        return a__layers[i__current_layer];
    }


    /**
     * Функция, возвращающая количество слоев на сцене
     *
     * @return  int
     */
    public int get_layers_count ()
    {
        return i__layers_count;
    }


    /**
     * Функция очистки текущего слоя
     */
    public void clear_current_layer()
    {
        a__layers[i__current_layer].clear();
    }


    /**
     * Функция добавления объекта на текущий слой
     *
     * @param  @c__basic_actor  o__ba_new_actor  Эктор, которого добавляем на сцену
     */
    public void add_actor_on_current_layer(c__basic_actor o__ba_new_actor)
    {
        a__layers[i__current_layer].add_actor(o__ba_new_actor);
    }


    /**
     * Функция удаления эктора с текущего слоя
     *
     * @param  @int  i__index  Индекс эктора, которого удаляем
     */
    public void delete_actor_from_current_layer(int i__index)
    {
        a__layers[i__current_layer].delete_actor_by_index(i__index);
    }


    /**
     * Функция получения слоя по идентификатору
     *
     * @param  @int  i__index  Индекс
     *
     * @return  c__basic_layer
     */
    public c__basic_layer get_layer_by_index(int i__index)
    {
        return a__layers[i__index];
    }


    /**
     * Функция, возвращающая эктора в который попадает точка.
     * Эктора с текущего слоя.
     *
     * @param  @float  f__x  Координата точки по оси X
     * @param  @float  f__y  Координата точки по оси Y
     *
     * @return с__basic_actor
     */
    public c__basic_actor get_selected_actor(float f__x, float f__y)
    {
        return a__layers[i__current_layer].get_selected_actor(f__x, f__y);
    }


    /**
     * Функция, обновляющая всё содержимое сцены
     */
    public void update_scene()
    {
        //
        // Выполняем для каждого слоя функцию обновления
        //
        for (c__basic_layer o__bl_layer : a__layers)
        {
            o__bl_layer.update_layer();
        }
    }

    //============================================================================//
}
