import java.util.Comparator;
import java.util.TreeMap;

public class DepartmentReport {
    public static void main(String[] args) {
        DepartmentDA departmentDA = new DepartmentDA();
        TreeMap<String, Department> sortedDepartmentMap = new TreeMap<>(Comparator.reverseOrder());
        sortedDepartmentMap.putAll(departmentDA.getDepartmentMap());
        for (Department department : sortedDepartmentMap.values()) {
            departmentDA.printDepartment(department);
        }
    }
}