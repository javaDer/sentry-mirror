package net.sta.sentrymirror.handler;

import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Random;


public class RandomExceptionGenerator {
    // 异常类型枚举
    enum ExceptionType {
        ARITHMETIC_EXCEPTION,
        NULL_POINTER_EXCEPTION,
        INDEX_OUT_OF_BOUNDS_EXCEPTION,
        FILE_NOT_FOUND_EXCEPTION,
        SQL_EXCEPTION,
        ILLEGAL_ARGUMENT_EXCEPTION
    }

    /**
     * 随机生成并抛出异常
     *
     * @throws Exception 随机异常
     */
    public static void generateRandomException() throws Exception {
        // 创建随机数生成器
        Random random = new Random();

        // 随机选择异常类型
        ExceptionType[] exceptionTypes = ExceptionType.values();
        ExceptionType selectedType = exceptionTypes[random.nextInt(exceptionTypes.length)];

        // 根据选择的类型抛出对应异常
        switch (selectedType) {
            case ARITHMETIC_EXCEPTION:
                // 除零异常
                throwArithmeticException();
                break;
            case NULL_POINTER_EXCEPTION:
                // 空指针异常
                throwNullPointerException();
                break;
            case INDEX_OUT_OF_BOUNDS_EXCEPTION:
                // 数组越界异常
                throwIndexOutOfBoundsException();
                break;
            case FILE_NOT_FOUND_EXCEPTION:
                // 文件未找到异常
                throwFileNotFoundException();
                break;
            case SQL_EXCEPTION:
                // SQL 异常
                throwSQLException();
                break;
            case ILLEGAL_ARGUMENT_EXCEPTION:
                // 非法参数异常
                throwIllegalArgumentException();
                break;
        }
    }

    // 除零异常
    private static void throwArithmeticException() {
        int a = 10;
        int b = new Random().nextInt(2); // 随机生成 0 或 1
        int result = (b == 0) ? 0 : a / b; // 避免除数为 0
    }

    // 空指针异常
    private static void throwNullPointerException() {
        String str = null;
        int length = str.length(); // 会抛出 NullPointerException
    }

    // 数组越界异常
    private static void throwIndexOutOfBoundsException() {
        int[] arr = new int[5];
        int index = new Random().nextInt(10); // 随机生成 0-9 的索引
        int value = arr[index % arr.length]; // 确保索引不越界
    }

    // 文件未找到异常
    private static void throwFileNotFoundException() throws FileNotFoundException {
        throw new FileNotFoundException("文件未找到");
    }

    // SQL 异常
    private static void throwSQLException() throws SQLException {
        throw new SQLException("数据库连接错误");
    }

    // 非法参数异常
    private static void throwIllegalArgumentException() {
        throw new IllegalArgumentException("非法参数");
    }

    // 主方法测试
//    public static void main(String[] args) {
//        // 多次调用展示随机异常
//        for (int i = 0; i < 10; i++) {
//            try {
//                System.out.println("第 " + (i + 1) + " 次异常测试:");
//                generateRandomException();
//            } catch (Exception e) {
//                System.out.println("捕获到异常: " + e.getClass().getSimpleName());
//                System.out.println("异常信息: " + e.getMessage());
//                System.out.println("-------------------");
//            }
//        }
//    }
}
