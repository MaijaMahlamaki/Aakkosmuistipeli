/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import java.util.Scanner;
import muistipeli.kayttoliittyma.Kayttoliittyma;

/**
 *
 * @author mahlamai
 */
public class Main {
  public static void main(String[] args) {
      Scanner lukija = new Scanner(System.in);
      Kayttoliittyma kayttis = new Kayttoliittyma(lukija);
      kayttis.kaynnista();
  }
    
}