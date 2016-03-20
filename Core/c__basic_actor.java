package com.example.numbersgame;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Bitmap;
import android.graphics.Matrix;

/**
 * Created by Александр on 13.03.2016.
 * Базовый абстрактный класс для элемента эктор.
 *
 * Эктор это элемент размещаемый на "слое"(с__basic_layer).
 */
public abstract class c__basic_actor
{

    protected float f__x_position;        // Позиция по X
    protected float f__y_position;        // Позиция по Y
    protected float f__x_acceleration;    // Ускорение по X
    protected float f__y_acceleration;    // Ускорение по Y
    protected float f__x_speed;           // Скорость по X
    protected float f__y_speed;           // Скорость по Y

    protected Bitmap o__bm_bmp;             // Битмап эктора

    protected int i__sprite_height;       // Высота спрайта
    protected int i__sprite_width;        // Ширина спрайта

    protected Matrix m__canvas_matrix;    // Матрица для рисования на канвасе

    protected boolean b__selected;        // Флаг, показывающий выбран элемент или нет


    //============================================================================//
    //  Функции установки и получения значений координат                          //
    //============================================================================//

    /**
     * Функция получения позиции по X
     *
     * @return  float
     */
    public float get_x_position()
    {
        return f__x_position;
    }


    /**
     * Функция установки позиции по X
     *
     * @param  @float  f__x  Позиция по X
     */
    public void set_x_position(float f__x)
    {
        this.f__x_position = f__x;
    }


    /**
     * Функция получения позиции по Y
     *
     * @return  float
     */
    public float get_y_position()
    {
        return f__y_position;
    }


    /**
     * Функция установки позиции по Y
     *
     * @param  @float  f__y  Позиция по Y
     */
    public void set_y_position(float f__y)
    {
        this.f__y_position = f__y;
    }

    //============================================================================//


    //============================================================================//
    //  Функции установки и получения значений ускорения                          //
    //============================================================================//

    /**
     * Функция получения ускорения по X
     *
     * @return  float
     */
    public float get_x_acceleration()
    {
        return f__x_acceleration;
    }


    /**
     * Функция установки ускорения по X
     *
     * @param  @float  f__x  Усокрение по X
     */
    public void set_x_acceleration(float f__x)
    {
        this.f__x_acceleration = f__x;
    }


    /**
     * Функция получения ускорения по Y
     *
     * @return  float
     */
    public float get_y_acceleration()
    {
        return f__y_acceleration;
    }


    /**
     * Функция установки ускорения по Y
     *
     * @param  @float  f__y  Усокрение по Y
     */
    public void set_y_acceleration(float f__y)
    {
        this.f__y_acceleration = f__y;
    }

    //============================================================================//


    //============================================================================//
    //  Функции установки и получения значений скорости                           //
    //============================================================================//

    /**
     * Функция получения скорости по X
     *
     * @return  float
     */
    public float get_x_speed()
    {
        return f__x_speed;
    }


    /**
     * Функция установки скорости по X
     *
     * @param  @float  f__x  Скорость по X
     */
    public void set_x_speed(float f__x)
    {
        this.f__x_speed = f__x;
    }


    /**
     * Функция получения скорости по Y
     *
     * @return  float
     */
    public float get_y_speed()
    {
        return f__y_speed;
    }


    /**
     * Функция установки скорости по Y
     *
     * @param  @float  f__y  Скорость по Y
     */
    public void set_y_speed(float f__y)
    {
        this.f__y_speed = f__y;
    }

    //============================================================================//


    //============================================================================//
    //  Функции установки и получения значений спрайта                            //
    //============================================================================//

    /**
     * Функция установки битмапа
     *
     * @param  @Bitmap  o__bm_bitmap  Битмап который будем устанавливать
     */
    public void set_bm_bmp(Bitmap o__bm_bitmap)
    {
        this.o__bm_bmp = o__bm_bitmap;
    }


    /**
     * Функциия получения битмапа
     *
     * @return Bitmap
     */
    public Bitmap get_bm_bmp()
    {
        return o__bm_bmp;
    }


    /**
     * Функция установки высоты спрайта
     *
     * @param  @int  i__height  Высота спрайта
     */
    public void set_sprite_height(int i__height)
    {
        this.i__sprite_height = i__height;
    }


    /**
     * Функция установки ширины спрайта
     *
     * @param  @int  i__width  Ширина спрайта
     */
    public void set_sprite_width(int i__width)
    {
        this.i__sprite_width = i__width;
    }


    /**
     * Функция получения высоты спрайта
     *
     * @return  int
     */
    public int get_sprite_height()
    {
        return i__sprite_height;
    }


    /**
     * Функция получения ширины спрайта
     *
     * @return  int
     */
    public int get_sprite_width()
    {
        return i__sprite_width;
    }

    //============================================================================//


    //============================================================================//
    //  Функции установки и получения матрицы                                     //
    //============================================================================//

    /**
     * Функция установки матрицы
     *
     * @param  @matrix  m__matrix  Матрица
     */
    public void set_canvas_matrix(Matrix m__matrix)
    {
        this.m__canvas_matrix = m__matrix;
    }


    /**
     * Функция получения матрицы
     *
     * @return  matrix
     */
    public Matrix get_canvas_matrix()
    {
        return m__canvas_matrix;
    }

    //============================================================================//


    /**
     * Функция обновления размеров и положения битмапа.
     * Вызывать после каждого изменения i__sprite_height и i__sprite_width.
     */
    private void update_sprite_size_and_position()
    {
        //
        // Проверяем присвоен ли эктору битмап
        //
        if (o__bm_bmp != null)
        {
            //
            // Проверяем нужно ли изменять размер битмапа
            //
            if (
                o__bm_bmp.getHeight() != i__sprite_height ||
                o__bm_bmp.getWidth()  != i__sprite_width
                )
            {
                //
                // Создаем новый битмап по образу старого, но с текущим размером
                //
                Bitmap o__bm_bmp_tmp = Bitmap.createScaledBitmap(
                        o__bm_bmp,
                        i__sprite_width,
                        i__sprite_height,
                        true);
                o__bm_bmp = o__bm_bmp_tmp; // Меняем старый битмап на новый
            }
        }

        // Изменяем положение элемента
        m__canvas_matrix.setTranslate(
                                this.f__x_position,
                                this.f__y_position);
    }


    /**
     * Функция проверки попадания входной точки в эктора
     *
     * @param  @float  f__x  Положение точки по X
     * @param  @float  f__y  Положение точки по Y
     *
     * @return  boolean
     */
    public boolean is_selected(float f__x, float f__y)
    {
        //
        // Проверяем лежит ли входная точка внутри эктора
        //
        if (
            f__x > this.f__x_position &&
            f__x < (this.f__x_position + this.i__sprite_width) &&
            f__y > this.f__y_position &&
            f__y < (this.f__y_position + this.i__sprite_height))
        {
            b__selected = true;
        }
        else
        {
            b__selected = true;
        }

        return b__selected;
    }


    /**
     * Функция отрисовки эктора на канвасе
     *
     * @param  @Canvas  o__canvas__field  Поле для отрисовки
     * @param  @Paint   o__paint__paint   Кисть для отрисовки
     */
    public void draw(Canvas o__canvas__field, Paint o__paint__paint)
    {
        o__canvas__field.drawBitmap(o__bm_bmp, m__canvas_matrix, o__paint__paint);
    }


    /**
     * Функция обновления параметров эктора.
     * Тут хранится логика изменения положения и размеров эктора со временем.
     */
    abstract void update();
}
