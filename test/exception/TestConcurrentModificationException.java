package exception;

import java.util.ArrayList;
import java.util.List;

public class TestConcurrentModificationException {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        /**
         * foreach 使用迭代器进行遍历
         * 首先int expectedModCount = modCount;
         * remove完成会modCount++
         * 迭代器使用next()拿到元素之前会checkForComodification()校验（ fail-fast 策略）
         * 不一致然后抛出异常
         *
         * 使用Iterator进行remove成功后会expectedModCount = modCount;
         * next()执行正常
         *
         * 解决方案
         * 1、使用迭代器
         * 2、使用stream filter
         */
        for (Integer integer : list) {
            list.remove(integer);
        }
    }
}
