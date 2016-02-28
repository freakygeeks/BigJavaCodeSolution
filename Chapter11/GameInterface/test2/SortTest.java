//  class to show use of Sortable interface

public class SortTest {
    public static void main(String[] args) {

//  create an array of IntNums, print them, sort them, and print them again

        IntNum[] nums = new IntNum[5];
        nums[0] = new IntNum(8);
        nums[1] = new IntNum(3);
        nums[2] = new IntNum(6);
        nums[3] = new IntNum(1);
        nums[4] = new IntNum(5);

        System.out.println("Values before sorting:");
        for (int i = 0 ; i < nums.length ; i++)
            System.out.println(nums[i]);
        Sort.selection_sort(nums);
        System.out.println("Values after sorting:");
        for (int i = 0 ; i < nums.length ; i++)
            System.out.println(nums[i]);

//  create an array of Employees, print them, sort them, and print them again

        Employee[] people = new Employee[4];
        people[0] = new Employee(444556666,"Shiva","Chaudhuri",75000);
        people[1] = new Employee(222334444,"Rosie","Rubel    ",64000);
        people[2] = new Employee(888776666,"Xiang","Zhang    ",67000);
        people[3] = new Employee(555667777,"Seham","Gorab    ",84000);

        System.out.println("Values before sorting:");
        for (int i = 0 ; i < people.length ; i++)
            System.out.println(people[i]);
        Sort.selection_sort(people);
        System.out.println("Values after sorting:");
        for (int i = 0 ; i < people.length ; i++)
            System.out.println(people[i]);
    }
}	// end class SortTest

