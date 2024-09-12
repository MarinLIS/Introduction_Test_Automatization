package homeworks.homework_02;

public class Main {
    public static void main(String[] args) {

        Folder folder1 = new Folder("Folder1");
        Folder folder2 = new Folder("Folder2");
        Folder folder3 = new Folder("Folder3");
        Folder folder4 = new Folder("Folder4");
        Folder folder5 = new Folder("Folder5");

        File file1 = new File("File1.txt");
        File file2 = new File("File2.txt");
        File file3 = new File("File3.txt");
        File file4 = new File("File4.txt");
        File file5 = new File("File5.txt");
        File file6 = new File("File6.txt");
        File file7 = new File("File7.txt");
        File file8 = new File("File8.txt");
        File file9 = new File("File9.txt");

        folder1.addComponent(folder3);
        folder1.addComponent(file1);
        folder1.addComponent(file2);

        folder2.addComponent(file3);
        folder2.addComponent(folder4);

        folder3.addComponent(file4);
        folder3.addComponent(file5);

        folder4.addComponent(file5);
        folder4.addComponent(file6);
        folder4.addComponent(file7);

        folder5.addComponent(file8);
        folder5.addComponent(file9);

        folder1.removeComponent(file1);

        folder1.showDetails();
        folder2.showDetails();
        folder3.showDetails();
        folder4.showDetails();
        folder5.showDetails();
    }
}
