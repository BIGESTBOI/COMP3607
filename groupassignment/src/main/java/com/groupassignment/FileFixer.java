package com.groupassignment;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileFixer {
    public static void main(String[] args) throws Exception{
        String csvFilePath = "studentDataSheet\\testSheet.csv";
        File csvFile = new File(csvFilePath);
        ArrayList<Student> students = new ArrayList<Student>();
        String row;

        //if csvFile exists
        if (csvFile.isFile()) {
            BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath));
            
            //read and discard first line
            csvReader.readLine();
            
            //store the data from csvFile into an ArrayList of type student
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                Student student = new Student(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9]);
                students.add(student);
            }
            csvReader.close();
        } 
    }

    // private static void renameAndMoveFile(File toBeRenamed, String newName) throws Exception{
    //     //create new path object from toBeRenamed
    //     Path toBeRenamedPath = Paths.get(toBeRenamed.getPath());
    //     Files.copy(toBeRenamedPath, (new File("filesToRename/renamedFiles/" + newName + ".pdf").toPath()), StandardCopyOption.REPLACE_EXISTING);
    // }

    // private static void missingSubmissions(ArrayList<Student> students){  //checks for missing submissions (requires a list of student submissions)
    //     ArrayList<Student> missing = new ArrayList<Student>();
    //     bool found;
    //     for(Student s: students){
    //         studentID = s.getIdNumber()
    //         found = false;
    //         while not end of the list of files
    //             pull ID section of convention2 name
    //                 if studentID.equals(ID);
    //                     found == true;
    //         if(found == false)
    //             missing.add(s);
    //     }
    //      //if she wants us to output it to a file
    //     File missingSubmissions = new File("./missingSubmissions.txt");
    //     FileWriter fw = new FileWriter("missingSubmissions.txt");
    //     for(Student s: missing){
    //         fw.write(s.getIdNumber() + " " + s.getFullName() + "\n");
    //     }
    // }

    // private static ArrayList<File> getFilesFromFolder(){
    //     File folder = new File("filesToRename");
    //     ArrayList<File> pdfFiles = new ArrayList<File>();

    //     File[] files = folder.listFiles();
        
    //     for(File file: files){
    //         if(file.getName().contains(".pdf")){
    //             pdfFiles.add(file);
    //         }
    //     }
    //     return pdfFiles;
    // }
}
