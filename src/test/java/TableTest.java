import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class TableTest {
    WebDriver driver;

    @BeforeMethod
    public void testDownloadUpload() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");


    }

    @Test
    public void webTabeleTest() throws InterruptedException {

        //How many rows in the table
        int rowCountb= driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
        System.out.println("row count is: "+rowCountb);

        //how many columns in the table
        int columnCountb= driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th")).size();
        System.out.println("row count is: "+columnCountb);

        //Retrieve the specific row/column data
        String valuetb= driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[2]/td[2]")).getText();
        System.out.println("Specified row/column data: "+valuetb);

        //Retrieve all the data from table
        for (int i =1; i<= rowCountb; i++){
            for(int j=1;j< columnCountb;j++){
                String tblData= driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
                System.out.print(tblData+"  ");
            }
            System.out.println();
        }

        //find the product price,which name related to product 3
        //print ID and name only
        for(int i=1;i<=rowCountb;i++){
            String tblIDtb= driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[1]")).getText();
            String tblProductName= driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[2]")).getText();
            System.out.println("tble id : "+tblIDtb+ " product name is : "+tblProductName);

            if(tblProductName.equals("Product 3")){
                String productPricetb= driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[3]")).getText();
                System.out.println(tblProductName+ " Relevent product price is : "+productPricetb);
                break;
            }
        }
        //select all the checkBoxes
        int pageCountb= driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
        List<WebElement> pages= driver.findElements(By.xpath("//ul[@id='pagination']/li"));

        for (int k=0; k<pageCountb;k++){
            pages.get(k).click();
            Thread.sleep(1000);
            for(int i =1;i<=rowCountb;i++){
                boolean atb= driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[4]/input")).isSelected();

                if(!atb){
                    driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[4]/input")).click();
                    Thread.sleep(300);
                }
            }
        }

        //Select one checkbox
        int tblRow=1;
        driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+tblRow+"]/td[4]/input")).click();
    }
}
