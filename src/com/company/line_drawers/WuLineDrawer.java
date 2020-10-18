package com.company.line_drawers;

import com.company.LineDrawer;
import com.company.PixelDrawer;

import java.awt.*;

public class WuLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public WuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x0, int y0, int x1, int y1) {
        boolean steep = Math.abs(y1 - y0) > Math.abs(x1 - x0);
        if (steep) {
            int c = x0; x0 = y0; y0 = c;
            c = x1; x1 = y1; y1 = c;
        }
        if (x0 > x1) {
            int c = x0; x0 = x1; x1 = c;
            c = y0; y0 = y1; y1 = c;
        }

        if (steep)
        pd.setPixel(y0, x0, Color.BLUE);
        else
            pd.setPixel(x0, y0, Color.BLUE);
        if (steep)
        pd.setPixel(y1, x1, Color.RED);
        else
            pd.setPixel(x1, y1, Color.RED);
        //DrawPoint(steep, x0, y0, 1); // Эта функция автоматом меняет координаты местами в зависимости от переменной steep
       // DrawPoint(steep, x1, y1, 1); // Последний аргумент — интенсивность в долях единицы
        float dx = x1 - x0;
        float dy = y1 - y0;
        float gradient = dy / dx;
        float y = y0 + gradient;
        for (int x = x0 + 1; x <= x1 - 1; x++) {
            pd.setPixel(x, (int) y, Color.BLUE);
            pd.setPixel(x, (int) y + 1, Color.BLUE);
            //DrawPoint(steep, x, (int)y, 1 - (y - (int)y));
            //DrawPoint(steep, x, (int)y + 1, y - (int)y);
            y += gradient;
        }
    }

    /*public WuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int x = x1; int y = y1;
        int Dx = x2 - x1; int Dy = y2 - y1;
        int e = 2 * Dy - Dx;
        float d;
        Color b1, b2;
        for (int i = 1; i <= Dx; i++) {
            d = -1F * e / (Dy + Dx) / 1.15F;
            if (e >= 0) {
                b1 = SetColor(1F / 2 - d);
                b2 = SetColor(1F / 2 + d);
                pd.setPixel(x, y, b1);
                pd.setPixel(x, y + 1, b2);
                y++;
                e += -2 * Dx + 2 * Dy;
            } else {
                b1 = SetColor(1F / 2 + d);
                b2 = SetColor(1F / 2 - d);
                pd.setPixel(x, y, b2);
                pd.setPixel(x, y - 1, b1);
                e += 2 * Dy;
            }
            x++;
        }
    }

    private Color SetColor(float t) {
        int c = (int) (255*t);
        Color res = new Color(c, c, c);
        return res;
    }*/
}
