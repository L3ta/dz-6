import java.util.*;

public class Main {

    public static boolean searchString(String[] array, String searchString) {
        for (String element : array) {
            if (element.equals(searchString)) {
                return true;
            }
        }
        return false;
    }

    public static void removeDuplicates(List<String> list) {
        Set<String> set = new HashSet<>(list);
        System.out.println("Список без дублів: " + set);
    }

    public static Set<String> getVendorsStartingWith(List<String> list, char letter) {
        Set<String> result = new HashSet<>();
        for (String vendor : list) {
            if (vendor.charAt(0) == letter) {
                result.add(vendor);
            }
        }
        return result;
    }

    public static int[] getMinMaxVendorLength(List<String> list) {
        if (list.isEmpty()) {
            return new int[]{0, 0};
        }

        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;

        for (String vendor : list) {
            int length = vendor.length();
            if (length < minLength) {
                minLength = length;
            }
            if (length > maxLength) {
                maxLength = length;
            }
        }

        return new int[]{minLength, maxLength};
    }

    public static List<String> sortVendorsAlphabetically(List<String> list) {
        List<String> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        return sortedList;
    }

    public static void main(String[] args) {
        String[] vendors = {"Asus", "MSI", "Gigabyte", "Palit", "Zotac"};
        String searchVendor = "MSI";
        System.out.println("Чи є в наявності: " + searchString(vendors, searchVendor));

        List<String> vendorsWithDuplicates = Arrays.asList("Asus", "MSI", "MSI", "Gigabyte", "Palit", "Zotac", "Zotac");
        removeDuplicates(vendorsWithDuplicates);

        char letter = 'M';
        Set<String> vendorsStartingWithM = getVendorsStartingWith(vendorsWithDuplicates, letter);
        System.out.println("Список виробників на літеру: " + letter + " без дублів: " + vendorsStartingWithM);

        int[] minMaxLengths = getMinMaxVendorLength(vendorsWithDuplicates);
        System.out.println("Найкоротша назва: " + minMaxLengths[0]);
        System.out.println("Найдовша назва: " + minMaxLengths[1]);

        List<String> sortedVendors = sortVendorsAlphabetically(vendorsWithDuplicates);
        System.out.println("Список за алфавітом: " + sortedVendors);
    }
}