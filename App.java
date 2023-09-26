import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("THE CONFLICT STATEMENT FROM THE SECOND COMPUTER");

        System.out.println(generateRandomGroups(readStudentList("Student List.txt"),4));

    }

    public static ArrayList<String> readStudentList(String filename){
        ArrayList<String> arr = new ArrayList<>();
        try {
            File f = new File(filename);
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                arr.add(sc.nextLine());
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return arr;
    }

    public static ArrayList<ArrayList<String>> generateRandomGroups(ArrayList<String> studentList,int numOfGroups){
        ArrayList<ArrayList<String>> groups = new ArrayList<>();
        Collections.shuffle(studentList);
        for(int i = 0;i<numOfGroups;i++){
            groups.add(new ArrayList<String>());
        }
        for(int i = 0; i < studentList.size();i++){
            groups.get(i%numOfGroups).add(studentList.get(i));
        }
        return groups;
    }
}
