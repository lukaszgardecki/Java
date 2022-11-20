package com.mojastrona.zad_60_jee_kalkulatoriloscifarby;

public class PaintCalculator {
    static final int SQM_TO_SQCM = 10_000;

    static int calculatePaintAmount(Room room, PaintDetails paintDetails) {
        int areaToPaint = room.getPaintArea();
        int coverage = paintDetails.getCoverage() * SQM_TO_SQCM; //m^2 na cm^2
        int multipleCoatsArea = areaToPaint * paintDetails.getCoats();
        double paintLiters = (double) multipleCoatsArea / coverage;
        double paintLitersRoundUp = Math.ceil(paintLiters);
        return (int)paintLitersRoundUp;
    }
}
