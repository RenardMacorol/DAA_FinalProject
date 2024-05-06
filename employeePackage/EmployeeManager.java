package employeePackage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void writeToCSV(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            for (Employee emp : employees) {
                writer.println(emp.getEmpNo() + "," + emp.getLastName() + "," + emp.getFirstName() + "," +
                        emp.getSalary() + "," + emp.getDepartment() + "," + emp.getJobDesc());
            }
            System.out.println("Employee data written to CSV file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //Deletion
    public void deleteToCSV(String filename, String empno) {
        String tempfile = "temp.csv";

        File oldFile = new File(filename);
        File newFile = new File(tempfile);

        try {
            FileWriter fw = new FileWriter(tempfile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            Scanner sc = new Scanner(oldFile);

            while (sc.hasNextLine()) {

                String read = sc.nextLine();
                Scanner strRead = new Scanner(read);

                String rread = strRead.next();

                if(!rread.equals(empno+","))
                {
                    System.out.print(rread);
                    pw.println(read);
                }

                strRead.close();
            }

            pw.flush();
            pw.close();
            sc.close();
            bw.close();
            fw.close();

            oldFile.delete();
            File dump = new File(filename);
            newFile.renameTo(dump);

            System.out.println("Delete Complete");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
