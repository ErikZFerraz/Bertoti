public class Main {
    public static void main(String[] args) {

        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        File file3 = new File("file3.txt");


        Directory directory1 = new Directory("Documents");
        Directory directory2 = new Directory("Pictures");
        Directory directory3 = new Directory("Backup");


        directory1.add(file1);
        directory1.add(file2);

        directory2.add(file3);


        directory3.add(directory1); 
        directory3.add(directory2);  


        System.out.println("Showing file system structure:");
        directory3.show(); 
    }
}
