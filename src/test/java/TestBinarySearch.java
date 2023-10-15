
import org.testng.annotations.Test;
import org.testng.Assert;
import org.example.BinarySearch;


public class TestBinarySearch {
    @Test
    public void BinarySearchTest(){
        int[] arr = { 2, 3, 4, 10, 40};
		int n = arr.length;
		int x = 10;
        BinarySearch ob = new BinarySearch();
        int result = ob.binarySearch(arr, x);
        Assert.assertEquals(result, 3);
    }
}
