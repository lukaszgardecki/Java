class Util {
    public static int indexOf(String src, String tgt) {
        int n = 0;
        if (src.contains(tgt)) {
           n = src.indexOf(tgt);
        } else {
            n = -1;
        }

        return n;
    }
}