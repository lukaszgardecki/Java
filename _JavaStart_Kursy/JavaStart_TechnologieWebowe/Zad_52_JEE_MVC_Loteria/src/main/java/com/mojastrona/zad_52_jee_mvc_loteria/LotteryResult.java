package com.mojastrona.zad_52_jee_mvc_loteria;

import java.util.List;

public class LotteryResult {
    private List<Integer> userNumbers;
    private List<Integer> lotteryNumbers;
    private List<Integer> winnerNumbers;

    public LotteryResult(List<Integer> userNumbers, List<Integer> lotteryNumbers, List<Integer> winnerNumbers) {
        this.userNumbers = userNumbers;
        this.lotteryNumbers = lotteryNumbers;
        this.winnerNumbers = winnerNumbers;
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

    public void setUserNumbers(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }

    public List<Integer> getLotteryNumbers() {
        return lotteryNumbers;
    }

    public void setLotteryNumbers(List<Integer> lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    public List<Integer> getWinnerNumbers() {
        return winnerNumbers;
    }

    public void setWinnerNumbers(List<Integer> winnerNumbers) {
        this.winnerNumbers = winnerNumbers;
    }
}
