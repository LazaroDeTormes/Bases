package com.example.proyectoiconosfx;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseAll{

	@JsonProperty("ResponseAll")
	public List<ResponseAllItem> responseAll;

	public List<ResponseAllItem> getResponseAll(){

		return responseAll;
	}

	@Override
 	public String toString(){
		return 
			"ResponseAll{" + 
			"responseAll = '" + responseAll + '\'' + 
			"}";
		}
}