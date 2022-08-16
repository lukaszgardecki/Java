class Info {

    public static void printCurrentThreadInfo() {
        // get the thread and print its info
        System.out.printf("name: %s\n", Thread.currentThread().getName());
        System.out.printf("priority: %s", Thread.currentThread().getPriority());
    }
}