package com.company.line_drawers;

import com.company.LineDrawer;
import com.company.PixelDrawer;

public class WuLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public WuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int x = x1; int y = y1;
        int Dx = x2 - x1; int Dy = y2 - y1;
        int e = 2 * Dy - Dx;
        double d;
        SolidBrush b1, b2;
        for (int i = 1; i <= Dx; i++)
        {
            d = -1F * e / (Dy + Dx) / 1.15F;
    }
        if (e >= 0)
        {
            b1 = new SolidBrush(SetColor(1F / 2 - d));
            b2 = new SolidBrush(SetColor(1F / 2 + d));
            pd.setPixel(x, y, b1);
            pd.setPixel(x, y + 1, b2);
            y++;
            e += -2 * Dx + 2 * Dy;
        }
        else
        {
            b1 = new SolidBrush(SetColor(1F / 2 + d));
            b2 = new SolidBrush(SetColor(1F / 2 - d));
            pd.setPixel(x, y, b2);
            pd.setPixel(x, y - 1, b1);
            e += 2 * Dy;
        }
        x++;
        b1.Dispose();
        b2.Dispose();
    }
}
