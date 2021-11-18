package TestsLesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.io.File;
import java.util.List;

public class SelectorsTest {

    @Test
    public void CssSelectorsTest() throws InterruptedException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers"+File.separatorChar+"chromedriver").getFile());
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://calc.by/building-calculators/laminate.html");
        Thread.sleep(3000);

        //поиск по id
        WebElement byId = driver.findElement(By.cssSelector("#calc_message"));
        // поиск по одному классу
        WebElement byClass = driver.findElement(By.cssSelector(".calc-footer"));
        // поиск по нескольким классам
        WebElement byClasses = driver.findElement(By.cssSelector(".wrap.t3-mainnav"));
        // поиск по тэгу
        WebElement byTag = driver.findElement(By.cssSelector("nav"));
        // поиск по атрибуту со значению
        WebElement byAtributeWithValue = driver.findElement(By.cssSelector("[itemprop='articleBody']"));
        // поиск по тэгу классу атрибуту
        WebElement byTagClassAtribute = driver.findElement(By.cssSelector("div.calc-header[style]"));
        // поиск дочернего элемента по классу
        WebElement childElementByClass = driver.findElement(By.cssSelector(".calc-container .order-line"));
        // поиск дочернего элемента по сложным параметрам
        WebElement childElementByAtributeClass = driver.findElement(By.cssSelector("[for='name_input'] span"));
        // поиск дочернего элемента который находится непосредственно под родителем
        WebElement childElementAfterParent = driver.findElement(By.cssSelector(".calc-content > .calc-btn-div"));
        // поиск элемента который находится сразу за первым элементом на одном уровне
        WebElement twinElementAfter = driver.findElement(By.cssSelector("label + input.form-control"));
        // поиск элемента который находится c первым элементом на одном уровне
        WebElement neighborsElementAfter = driver.findElement(By.cssSelector("label ~ input"));
        // поиск элемента по части атрибута
        WebElement partElementAtribut = driver.findElement(By.cssSelector("[for *= 'input']"));
        // поиск элемента по части атрибута которая точно стоит в начале названия атрибута
        WebElement fisrtPartElementAtribut = driver.findElement(By.cssSelector("[for ^= 'email']"));
        // поиск элемента по части атрибута которая точно стоит в конце названия атрибута
        WebElement lastPartElementAtribut = driver.findElement(By.cssSelector("[for $= 'put']"));
        // поиск элемента который является первым ребенком у родителя
        WebElement firstChildElementAtribut = driver.findElement(By.cssSelector(".orderform-label:first-child"));
        // поиск элемента который является последним ребенком у родителя
        WebElement lastChildElementAtribut = driver.findElement(By.cssSelector("li:last-child"));
        // поиск элемента который является энным ребенком у родителя
        WebElement nthChildElementAtribut = driver.findElement(By.cssSelector("li:nth-child(2)"));

        List <WebElement> byAtribute = driver.findElements(By.cssSelector("[itemprop]"));
        System.out.println(byAtribute.size());

        driver.quit();
    }
    @Test
public void XPathTest() throws InterruptedException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers"+File.separatorChar+"chromedriver").getFile());
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://calc.by/building-calculators/laminate.html");
        Thread.sleep(3000);

        //поиск элемента по тэгу
        WebElement byTag = driver.findElement(By.xpath("//input"));
        //поиск элемента по атрибуту (классу)
        WebElement byAtribute = driver.findElement(By.xpath("//*[@itemprop]"));
        //поиск элемента по значению атрибута (классу)
        WebElement byAtributeValue = driver.findElement(By.xpath("//*[@itemprop = 'inLanguage']"));
        //поиск элемента по тэгу и классу полное значение
        WebElement byTagAndClassWithFullValue = driver.findElement(By.xpath("//div[@class = 'order-line clearfix']"));
        //поиск элемента по значению класса
        WebElement byClassValue = driver.findElement(By.xpath("//div[contains(@class,'order-line')]"));
        //поиск элемента по тексту, можно еще писать "//*[. = 'Длина комнаты']"
        WebElement byText = driver.findElement(By.xpath("//*[text() = 'Длина комнаты']"));
        //поиск элемента по тексту, который есть в атрибуте
        WebElement byContainsText = driver.findElement(By.xpath("//*[contains(text(), 'Калькулятор для расчета ламината')]"));
        //поиск элемента по двум атрибутам используя and (то же самое со словом or или не равно !=)
        WebElement byTwoAtributesWithAnd = driver.findElement(By.xpath("//*[@class = 'calc-input' and @value = '320']"));
        //поиск родительского элемента от его ребенка (поднимаемся на 1 уровень)
        WebElement byChildToParent = driver.findElement(By.xpath("//*[. = 'Ширина комнаты']/.."));
        //поиск родительского элемента от его ребенка (поднимаемся больше чем на 1 уровень)
        WebElement byChildToParent2 = driver.findElement(By.xpath("//*[. = 'Ширина комнаты']/ancestor::section"));
        //поиск ребенка от его родительского элемента можно и так   //*[@class = 'calc-container']//div[@class = 'submit-div']
        WebElement byParentToChild1 = driver.findElement(By.xpath("//*[@class = 'calc-container']/descendant::*[@class = 'submit-div']"));
        WebElement byParentToChild2 = driver.findElement(By.xpath("//*[@class = 'calc-container']//div[@class = 'submit-div']"));
        //поиск дочернего элемента сразу после родительского (Спускаемся на 1 уровень)
        WebElement byChildRightAfterParent = driver.findElement(By.xpath("//*[@class = 'calc-container']/div"));
        //поиск дочернего элемента сразу после родительского (Спускаемся на 2 уровень)
        WebElement byChildRightAfterParent2 = driver.findElement(By.xpath("//*[@class = 'calc-container']/div[2]"));
        //поиск дочернего элемента сразу после родительского (Спускаемся на последний уровень)
        WebElement byChildRightAfterParentLast = driver.findElement(By.xpath("//*[@class = 'calc-container']/div[last()]"));
        //Получение всех элементов с тегом div от начала до элемента с указанным классом
        WebElement getAllElementsBeforeCurrent = driver.findElement(By.xpath("//*[@class = 'calc-container']/preceding::div"));
        //Получение всех элементов с тегом div от текущего элемента с указанным классом до конца
        WebElement getAllElementsAfterCurrent = driver.findElement(By.xpath("//*[@class = 'calc-container']/following::div"));

        driver.quit();
}

}
