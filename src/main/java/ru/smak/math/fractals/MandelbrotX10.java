package ru.smak.math.fractals;

import ru.smak.math.Complex;

public class MandelbrotX10 extends Mandelbrot{
    @Override
    public float isInSet(Complex c) {
        Complex z = new Complex(0.0);
        int cnt = 0;
        var r2 = this.getR() * this.getR();
        while (++cnt < this.getMaxIterations()) {
            z = z.times(z).times(z).times(z).times(z).times(z).times(z).times(z).times(z).times(z).plus(c);
            if (z.abs2() >= r2) break;
        }
        return (float)cnt / this.getMaxIterations();
    }
}
