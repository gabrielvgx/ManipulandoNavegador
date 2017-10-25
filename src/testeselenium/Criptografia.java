/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeselenium;

/**
 *
 * @author Familia
 */
public class Criptografia {

    public static String criptografar(String senha) {
        char[] vetorSenha = senha.toCharArray();
        senha = "";
        for (int i = 0; i < vetorSenha.length; i++) {
            char caracter = vetorSenha[i];
            caracter += 1;
            vetorSenha[i] = caracter;
            senha += vetorSenha[i];
        }
        return senha;
    }
    public static String criptografia2(String senha){
        byte[] bytes = senha.getBytes(); 
        String senhaCriptografada = "";
        String[] binarios = new String[bytes.length];  
        for (int i=0; i < bytes.length; i++) {  
            binarios[i] = Integer.toBinaryString(bytes[i]);  
            senhaCriptografada += binarios[i] + " ";
        }
        return senhaCriptografada;
    }
    public static String descriptografar2(String senha){
        String[] vetorSenha = senha.split(" ");
        StringBuilder texto2 = new StringBuilder();  
        for (String senha1 : vetorSenha) {
            texto2.append((char) Integer.parseInt(senha1, 2));  
        }
        return texto2.toString();
    }

    public static String descriptografar(String senha) {
        char[] vetorSenha = senha.toCharArray();
        senha = "";
        for (int i = 0; i < vetorSenha.length; i++) {
            char caracter = vetorSenha[i];
            caracter -= 1;
            vetorSenha[i] = caracter;
            senha += vetorSenha[i];
        }
        return senha;
    }
}
