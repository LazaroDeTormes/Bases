package com.example.proyectoiconosfx.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response{

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



	public String getName(){
		return name;
	}

	public List<String> getUnicode(){
		return unicode;
	}
	public List<String>	getHtmlCode(){return htmlCode;}
	public String getGroup(){return group;}

	@Override
	public String toString() {
		return "Response{" +
				"htmlCode=" + htmlCode +
				", name='" + name + '\'' +
				", unicode=" + unicode +
				", category='" + category + '\'' +
				", group='" + group + '\'' +
				'}';
	}
}