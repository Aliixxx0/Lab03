import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sorter2 {
    public static void main(String[] args) throws Exception {

        System.out.println("THE CONFLICT STATEMENT FROM THE SECOND COMPUTER");
        ArrayList<String> arr=new ArrayList<>();
        arr=(readStudentList("Student List.txt"));
        ArrayList<ArrayList<String>> groups = new ArrayList<>();
        ArrayList<ArrayList<String>> groups2 = new ArrayList<>();
        groups= generateRandomGroups(arr,4);
        groups2= generateRandomGroups(arr,4);
        System.out.println("Group1:"+groups);
        System.out.println("Group2:"+groups2);
        sor2(groups);
        System.out.println("After selectionSort group1:"+groups);
        sort(groups2);
        System.out.println("After insertingSort group2:"+groups2);

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
    public static void insertionSort(ArrayList<String> arr) {
        int n = arr.size();
        for (int i = 1; i < n; i++) {
            String tmp = arr.get(i);
            int j = i - 1;
            while (j >= 0 && tmp.compareTo(arr.get(j)) < 0) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, tmp);
        }
    }public static void selectionSortNames(ArrayList<String> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr.get(j).compareTo(arr.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Collections.swap(arr, i, minIndex);
        }
    }

    public static void sort(ArrayList<ArrayList<String>> arr) {
        for (ArrayList<String> subList : arr) {
            insertionSort(subList);
        }
    } public static void sor2(ArrayList<ArrayList<String>> arr) {
        for (ArrayList<String> subList : arr) {
            selectionSortNames(subList);
        }
    }
}