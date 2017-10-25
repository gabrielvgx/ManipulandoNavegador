package testeselenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Familia
 */
public class TesteSelenium {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AWTException {
        String pass = "100101 1110101 1100110 1100100 1101001 1110101 1110110 1100101 1110000 1001000 1010111 1001000 1011001 100101 111001 110111 110001 111001";
        String pass2 = "100101 1110101 1100110 1100100 1101001 1110101 1110110 1100101 1110000 1101000 1110111 1101000 1111001 100101";
        int op;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("1 - Facebook\n2 - Gmail\n3 - All\n4 - ACAD\n5 - Sair"));
            switch (op) {
                case 1:
                    driver.get("https://www.facebook.com/");
                    WebElement txt = driver.findElement(By.name("email"));
                    WebElement txt2 = driver.findElement(By.name("pass"));
                    txt.sendKeys("gabrielvgx@gmail.com");
                    txt2.sendKeys(Criptografia.descriptografar(Criptografia.descriptografar2(pass)));
                    txt2.submit();
                    break;
                case 2:
                    driver.get("https://gmail.com");
                    WebElement txt3 = driver.findElement(By.name("identifier"));
                    txt3.sendKeys("gabrielvgx@gmail.com");
                    Robot robo = new Robot();
                    robo.keyPress(KeyEvent.VK_ENTER);
                    robo.keyRelease(KeyEvent.VK_ENTER);
                    robo.delay(2000);
                    WebElement campoSenha = driver.findElement(By.name("password"));
                    campoSenha.sendKeys(Criptografia.descriptografar(Criptografia.descriptografar2(pass2)));
                    robo.keyPress(KeyEvent.VK_ENTER);
                    robo.keyRelease(KeyEvent.VK_ENTER);
                    break;
                case 3:
                    driver.get("https://www.facebook.com/");
                    WebElement txt4 = driver.findElement(By.name("email"));
                    WebElement txt5 = driver.findElement(By.name("pass"));
                    txt4.sendKeys("gabrielvgx@gmail.com");
                    txt5.sendKeys(Criptografia.descriptografar(Criptografia.descriptografar2(pass)));
                    txt5.submit();
                    break;
                case 4:
                    driver.get("https://www.acad.cefetmg.br/qacademico/index.asp?t=1001");
                    WebElement login = driver.findElement(By.name("login"));
                    WebElement senha = driver.findElement(By.name("senha"));
                    WebElement botaoEntrar = driver.findElement(By.name("entrar"));
                    login.sendKeys("201511130113");
                    senha.sendKeys(Criptografia.descriptografar(Criptografia.descriptografar2(pass)));
                    botaoEntrar.click();
                    driver.get("https://www.acad.cefetmg.br/qacademico/index.asp?t=2071");
                    List<WebElement> a = driver.findElements(By.className("conteudoTexto"));
                    System.out.println("a: " + a.size());
                    List<String> notasPrimeiroBimestre = new ArrayList<>();
                    for (int i = 0; i < a.size(); i++) {
                        if (a.get(i).getText().contains("Nota 1º Bimestre")) {
                            notasPrimeiroBimestre.add(a.get(i).getText());
                        }
                        System.out.println(a.get(i).toString());
                    }
                    System.out.println("notas: " + notasPrimeiroBimestre.size());
                    break;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao Invalida! Tente Novamente!");
            }
        } while (op != 5);

    }

}
