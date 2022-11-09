package Zad_10_KonwerterJednostek;

class Convert {
    public static void main(String[] args) {
        UnitConverter unitConverter = new UnitConverter();
        TimeConverter timeConverter = new TimeConverter();

        double result1 = unitConverter.cmTOm(1678);
        double result2 = unitConverter.mmTOm(14657);
        double result3 = unitConverter.mTOcm(0.435);
        double result4 = unitConverter.mTOmm(1.34);

        int result5 = timeConverter.hTOm(3);
        int result6 = timeConverter.mTOs(34);
        int result7 = timeConverter.sTOms(200);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
        System.out.println(result7);

    }
}
