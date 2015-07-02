package com.ckg;

public class Countries {
	private String code;
    private String name;
    private String capital;  
    private int Area;
    private int population;  
    private String continent;
    public Countries(String code,String name, String continent,int area,int population, String capital )
    {      
      this.setCode(code);
      this.setName(name);
      this.setContinent(continent);
      this.setArea(area);
      this.setPopulation(population);
      this.setCapital(capital);
    }
    public Countries() {
    	  
    }
    public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public int getArea() {
		return Area;
	}
	public void setArea(int area) {
		Area = area;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	
   

}
