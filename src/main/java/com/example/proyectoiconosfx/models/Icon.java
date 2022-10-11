package com.example.proyectoiconosfx.models;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Icon implements Serializable {

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

	public Icon() {
	}

	public Icon(List<String> htmlCode, String name, List<String> unicode, String category, String group) {
		this.htmlCode = htmlCode;
		this.name = name;
		this.unicode = unicode;
		this.category = category;
		this.group = group;
	}

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