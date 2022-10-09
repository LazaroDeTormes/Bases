package com.example.proyectoiconosfx;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseAllItem{

	@JsonProperty("htmlCode")
	public List<String> htmlCode;

	@JsonProperty("name")
	public String name;

	@JsonProperty("unicode")
	public List<String> unicode;

	@JsonProperty("category")
	public String category;

	@JsonProperty("group")
	public String group;

	public List<String> getHtmlCode(){
		return htmlCode;
	}

	public String getName(){
		return name;
	}

	public List<String> getUnicode(){
		return unicode;
	}

	public String getCategory(){
		return category;
	}

	public String getGroup(){
		return group;
	}

	@Override
 	public String toString(){
		return 
			"ResponseAllItem{" + 
			"htmlCode = '" + htmlCode + '\'' + 
			",name = '" + name + '\'' + 
			",unicode = '" + unicode + '\'' + 
			",category = '" + category + '\'' + 
			",group = '" + group + '\'' + 
			"}";
		}
}