package com.study.lambda;

import java.math.BigInteger;
import java.util.stream.Stream;

/*
Stream API提供了一套新的流式处理的抽象序列；
Stream API支持函数式编程和链式操作；
Stream可以表示无限序列，并且大多数情况下是惰性求值的。
 */

public class StreamLambda {
    public static void main(String[] args) {
        //它可以“存储”有限个或无限个元素。这里的存储打了个引号，是因为元素有可能已经全部存储在内存中，也有可能是根据需要实时计算出来的。
        Stream<BigInteger> naturals = null;//= createNaturalStream();;

        //一个Stream可以轻易地转换为另一个Stream，而不是修改原Stream本身
        naturals.map(n -> n.multiply(n)) // 1, 4, 9, 16, 25...
                .limit(100)
                .forEach(System.out::println);//这里才计算，惰性计算；
        //惰性计算的特点是：一个Stream转换为另一个Stream时，实际上只存储了转换规则，并没有任何计算发生。

    }
}
