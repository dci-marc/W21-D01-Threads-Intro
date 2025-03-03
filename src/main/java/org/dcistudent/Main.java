package org.dcistudent;

import org.dcistudent.dtos.countries.Country;
import org.dcistudent.factories.countries.CountryFactory;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    new Main();
  }

  public Main() {
    Runnable runnable = () -> {
      try {
        Main.getCountry("Cuba");
        Thread.sleep(1000);
        Main.getCountry("Palestine");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    };

    Thread thread = new Thread(runnable);
    thread.start();
  }

  private static void getCountry(String countryName) {
    Country country = CountryFactory.getInstance().getByName(countryName);
    if (country.isPresent() == false) {
      System.out.println("Country not found");
      return;
    }

    System.out.printf(
        "%s is a great country with a great population of %d and is in %s continent. With the following capitals: %s%n",
        country.getName().getCommon(),
        country.getPopulation(),
        Arrays.toString(country.getContinents()),
        Arrays.toString(country.getCapitals())
    );
  }
}