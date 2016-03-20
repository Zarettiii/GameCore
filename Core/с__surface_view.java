package com.example.numbersgame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Timer;

/**
 * Created by Александр on 20.03.2016.
 * Поверхность для рисования.
 */
public class с__surface_view extends SurfaceView implements SurfaceHolder.Callback
{
    c__basic_scene o__bs_scene;  // Сцена
    с__drawer_task o__dt_drawer; // Отрисовщик
    Canvas         o__c_canvas;  // Канвас
    Timer          o__t_timer;   // Таймер

    /**
     * Конструктор
     *
     * @param  @Context         o__c_context     Контекст
     * @param  @c__basic_scene  o__bs_new_scene  Сцена
     */
    public с__surface_view(Context o__c_context, c__basic_scene o__bs_new_scene)
    {
        super(o__c_context);

        o__bs_scene  = o__bs_new_scene;                                   // Устанавливаем сцену
        o__dt_drawer = new с__drawer_task(this.getHolder(), o__bs_scene); // Устанавливаем отрисовщик

        this.getHolder().addCallback(this); // Привязываем холдер к surface
    }


    /**
     * Функция конструктор для surface
     *
     * @param  @SurfaceHolder  holder  Холдер
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        //
        // Устанавливаем периодичный вызов отрисовщика
        //
        o__t_timer.scheduleAtFixedRate(o__dt_drawer, 0, 35);

        o__c_canvas = this.getHolder().lockCanvas(); // Устанавливаем канвас

        this.getHolder().unlockCanvasAndPost(o__c_canvas); // Открываем канвас
    }


    /**
     * Функция, вызываемая при изменении surface
     *
     * @param  @SurfaceHolder  holder  Холдер
     * @param  @int            format  Формат
     * @param  @int            width   Ширина
     * @param  @int            height  Высота
     */
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
    {

    }

    /**
     * Функция деструктор для surface
     *
     * @param  @SurfaceHolder  holder  Холдер
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        o__t_timer.cancel(); // Отключаем таймер
    }


    //============================================================================//
    //  Функции для работы со сценами                                             //
    //============================================================================//

    /**
     * Функция установки сцены
     *
     * @param  @c__basic_scene  o__bs_new_scene  Новая сцена
     */
    public void set_bs_scene(c__basic_scene o__bs_new_scene)
    {
       o__bs_scene = o__bs_new_scene;
    }


    /**
     * Функция получения сцены
     *
     * @return  c__basic_scene
     */
    public c__basic_scene get_bs_scene()
    {
        return o__bs_scene;
    }

    //============================================================================//
}
