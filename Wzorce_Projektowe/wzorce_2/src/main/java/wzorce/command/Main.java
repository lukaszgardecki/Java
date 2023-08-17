package wzorce.command;

class Main {
    public static void main(String[] args) {
        TextFileOperationExecutor executor = new TextFileOperationExecutor();
        String s1 = executor.executeOperation(new OpenTextFileOperation(new TextFile("file1.txt")));
        String s2 = executor.executeOperation(new SaveTextFileOperation(new TextFile("file2.txt")));

        System.out.println(s1);
        System.out.println(s2);
    }
}
