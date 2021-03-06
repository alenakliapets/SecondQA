package TestsLesson11.ClassWork.Wrapers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {

    private  UIElement uiElement;
    private  WebDriver driver;
    private  List<TableRow> rowList = new ArrayList<>();
    private List<String> columnList= new ArrayList<>();

    /***
     * Универсальный элемент таблицы
     * @param driver
     * @param by основывается на тэге table
     */
    public Table(WebDriver driver, By by) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, by);

        for (WebElement element: this.uiElement.findElements(By.xpath("//tr[@class ='header']/th"))){
            columnList.add(element.getText());
        }
        for (WebElement element: this.uiElement.findElements(By.xpath("//tr[@class !='header']"))){
            rowList.add(new TableRow(driver, element));
        }
    }

    public int rowsCount(){
        return rowList.size();
    }

    public UIElement getElementFromCell(int rowIndex, int columnIndex){
        return rowList.get(rowIndex).getCellByIndex(columnIndex).getUIElement();
    }

    public UIElement getElementFromCell(String expectedText, int expectedColumn, int columnIndex){
        for (TableRow row:rowList){
            if (row.getCellByIndex(expectedColumn).getUIElement().getText().equalsIgnoreCase(expectedText)){
                return row.getCellByIndex(columnIndex).getUIElement();
            }
        }

return null;
    }
    public UIElement getElementFromCell(String expectedText, int expectedColumn, String columnName){
        return getElementFromCell(expectedText, expectedColumn, columnList.indexOf(columnName));
    }

}
