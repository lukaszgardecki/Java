package rozdzial_4;

public class zad1 {

/*
* Masz dwie 32-bitowe liczby, N i M, oraz dwie pozycje bitó, i oraz j. Napisz metodę, która
* wstawia M do N w taki sposób, że M rozpoczyna się od bitu j i kończy w bicei i. Przyjmij, że
* liczba bitów od j do i jest wystarczająca, aby zmieścić całą wartośćM. Jeśli więc M = 10011,
* możesz założyć, że między j a i jest przynajmniej pięć bitó. W takiej sytuacji niedozwolona
* jest sytuacja, w której j = 3 oraz i = 2, ponieważ M nie zmieści się w całości między bitami
* trzecim i drugim.
*
* PRZYKŁAD
* Dane wejściowe: N = 10000000000, M = 10011, i = 2, j = 6
* Dane wyjściowe: 10001001100
*/


    static int updateBits(int n, int m, int i, int j) {
        int allOnes = ~0;
        int left = allOnes << (j + 1);
        int right = ((1 << i) - 1);
        int mask = left | right;
        int nCleared = n & mask;
        int mShifted = m << i;
        return nCleared | mShifted;
    }
}
