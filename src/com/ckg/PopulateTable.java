package com.ckg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class PopulateTable
 */
@WebServlet("/PopulateTable")
public class PopulateTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 static Logger log = Logger.getLogger(PopulateTable.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulateTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		log.info("PopulateTable is called");
		  ArrayList<Countries> country=new ArrayList<Countries>();
		  log.info("reday to fetch data FetchData.getAllCountries()");
		  country=FetchData.getAllCountries();
		  log.info("FetchData.getAllCountries() fetched data");
		  Gson gson = new Gson();
		  JsonElement element = gson.toJsonTree(country, new TypeToken<List<Countries>>() {}.getType());

		  JsonArray jsonArray = element.getAsJsonArray();
		  response.setContentType("application/json");
		  response.getWriter().print(jsonArray);
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
