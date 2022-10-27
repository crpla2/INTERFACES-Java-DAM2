/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversordivisas;

/**
 *
 * @author DAM2Alu10
 */
public class NewClass {

    public static void main(String[] args) {
        Divisa yeng = new Divisa("yeng", " 0.99");
        System.out.println(yeng.aEuros("100"));
        System.out.println(yeng.deEuros("100"));
    }
}
