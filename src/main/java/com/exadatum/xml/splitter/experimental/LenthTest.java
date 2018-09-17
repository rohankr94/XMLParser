package com.exadatum.xml.splitter.experimental;

public class LenthTest {

    public static void main(String[] args) {
        String test="|2018-09-11T00:31:41.779Z|N|INSERT|ADD|10679||||||||||||||||||||||5812448|Robertson, DonaldDonaldRobertsonRobertson|||||Robertson|Robertson, Donald||Donald|Robertson||||||F|12728|OPERATOR - IC||||10007||Tuesday|2018-08-28|2018-08-28|1|2018-08-28T22:00:00.000-06:00|354068359|2018-08-28T20:53:00.000-06:00||||";
        System.out.println(test.split("\\|").length);
    }
}
