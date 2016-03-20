package com.example.numbersgame;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import java.util.TimerTask;

/**
 * Created by Александр on 20.03.2016.
 * Отрисовщик.
 *
 * Выполняет функции отрисовки экторов на канвасе.
 */
public class с__drawer_task extends TimerTask
{
    SurfaceHolder   o__sh_holder;  // Холдер
    Paint           o__p_paint;    // Кисть
    c__basic_scene  o__bs_scene;   // Сцена
    c__basic_layer  o__bl_layer;   // Слой
    Canvas          o__c_canvas;   // Канвас


    /**
     * Конструктор
     *
     * @param  @SurfaceHolder   o__sh_new_holder  Холдер
     * @param  @c__basic_scene  o__bs_new_scene   Сцена
     */
    public с__drawer_task(SurfaceHolder o__sh_new_holder, c__basic_scene o__bs_new_scene)
    {
        o__sh_holder = o__sh_new_holder; // Устанавливаем холдер
        o__bs_scene  = o__bs_new_scene;  // Устанавливаем сцену
        o__p_paint   = new Paint();      // Создаем кисть
    }


    /**
     * Реализация абстрактного метода родителя
     */
    @Override
    public void run()
    {
        try
        {
            o__c_canvas = null;                       // Присваеваем нулл
            o__c_canvas = o__sh_holder.lockCanvas();  // Создаем поверхность для рисования

            o__c_canvas.drawRGB(0, 0, 0);             // Закрашиваем канвас черным цветом

            //
            // В этом цикле мы перебираем и все слои на сцене и отрисовываем всех экторов
            // на них.
            //
            for (int i = 0; i < o__bs_scene.get_layers_count(); i++)
            {
                //
                // Устанавливаем слой с которым будем работать
                //
                o__bl_layer = o__bs_scene.get_layer_by_index(i);

                //
                // Если слой существует, то начинаем отрисовывать экторов
                //
                if (o__bl_layer != null)
                {
                    o__p_paint = o__bl_layer.o__paint; // Устанавливаем кисть для этого слоя

                    //
                    // Отрисовываем всех экторов на канвасе
                    //
                    for (c__basic_actor o__ba_actor : o__bl_layer.o__ll_actors)
                    {
                        o__ba_actor.draw(o__c_canvas, o__p_paint);
                    }
                }
            }

            o__bs_scene.update_scene(); // Обновляем сцену

        }
        catch (Exception o__e_exc)
        {

        }
        finally
        {
            if (o__c_canvas != null)
            {
                //
                // После "инициализации" канваса и нанесения на него всех слоев и экторов,
                // открываем канвас для редактирования извне.
                //
                o__sh_holder.unlockCanvasAndPost(o__c_canvas);
            }
        }
    }
}
